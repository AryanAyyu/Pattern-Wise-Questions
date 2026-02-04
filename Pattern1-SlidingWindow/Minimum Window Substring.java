//Link : https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] freqT = new int[128];
        for (char c : t.toCharArray()) {
            freqT[c]++;
        }

        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char rChar = s.charAt(right);

            if (freqT[rChar] > 0) {
                required--;
            }
            freqT[rChar]--;
            right++;

            // window is valid
            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lChar = s.charAt(left);
                freqT[lChar]++;
                if (freqT[lChar] > 0) {
                    required++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
