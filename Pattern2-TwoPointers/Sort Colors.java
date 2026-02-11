//Link : https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int left =0;
        int mid=0;
        int right = nums.length-1;
        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,left,mid);
                left++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,right);
                right--;
            }
        }
    }
    private void swap(int arr[],int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]=temp;
    }
}