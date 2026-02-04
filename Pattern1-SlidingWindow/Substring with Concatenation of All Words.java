//Link : https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> list = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return list;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int windowLen = wordLen * wordCount;

        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> window = new HashMap<>();
            int left = i, count = 0;

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (map.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > map.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) {
                        list.add(left);
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return list;
    }
}
