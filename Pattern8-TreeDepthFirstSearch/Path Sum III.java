//Link: https://leetcode.com/problems/path-sum-iii/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        return dfs(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    private int dfs(TreeNode node , long target){
        if(node==null) return 0;
        int count =0;
        if(node.val==target){
            count++;
        }
        count+=dfs(node.left,target-node.val);
        count+=dfs(node.right,target-node.val);
        return count;
    }
}