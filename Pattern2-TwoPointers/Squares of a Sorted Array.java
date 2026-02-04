// Link: https://leetcode.com/problems/squares-of-a-sorted-array/description/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];

        int left =0;
        int right = n-1;
        int end=n-1;

        while(left<=right){
            int leftSq = nums[left]*nums[left];
            int rightSq = nums[right]*nums[right];

            if(leftSq>rightSq){
                result[end]=leftSq;
                left++;
            }else{
                result[end]=rightSq;
                right--;
            }
            end--;
        }
        return result;

    }
}