// Link: https://leetcode.com/problems/minimum-size-subarray-sum/description/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0;
        int sum =0;
        int count =Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){
                count=Math.min(count,i-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return count==Integer.MAX_VALUE?0:count;
    }
}