//Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/

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
    public int maxLevelSum(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        if(root==null) return 0;
        int count=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            int sum = 0;
            for(int i=0;i<level.size();i++){
                sum+=level.get(i);
            }
            result.add(sum);
        }
        for(int i=0;i<result.size();i++){
            if(result.get(i)>max){
                count=i+1;
            }
            max = Math.max(max,result.get(i));

        }
        return count;
    }
}