//Link: https://leetcode.com/problems/letter-case-permutation/description/

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(0,s.toCharArray(),result);
        return result;
    }
    private void backtrack(int index, char[] letter,List<String> result){
        if(index == letter.length){
            result.add(new String(letter));
            return;
        }

        if(Character.isLetter(letter[index])){
            letter[index] = Character.toLowerCase(letter[index]);
            backtrack(index+1,letter,result);

            letter[index] = Character.toUpperCase(letter[index]);
            backtrack(index+1,letter,result);
        }else{
            backtrack(index+1,letter,result);
        }
    }
}