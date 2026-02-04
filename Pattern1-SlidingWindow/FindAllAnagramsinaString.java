//Link : https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        if(p.length()>s.length()) return list;
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(char ch : p.toCharArray()){
            freq1[ch-'a']++;
        }
        int left = 0;
        for(int right =0; right<s.length();right++){
            freq2[s.charAt(right)-'a']++;

            if(right-left+1>p.length()){
                freq2[s.charAt(left)-'a']--;
                left++;
            }

            if(right-left+1==p.length()){
                if(matches(freq1,freq2)){
                    list.add(left);
                }
            }
        }
        return list;
    }

    private boolean matches(int[] a, int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i])return false;
        }
        return true;
    }
}