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
    int maxSumFoundYet = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxChildSum(root);
        return maxSumFoundYet;
    }

    private int maxChildSum(TreeNode root) {
        if(root == null) return 0;

        int leftMaxSum = maxChildSum(root.left);
        int rightMaxSum = maxChildSum(root.right);

        int maxSum = Math.max(root.val, root.val + leftMaxSum);
        maxSum = Math.max(maxSum, root.val + rightMaxSum);
        maxSumFoundYet = Math.max(maxSumFoundYet, maxSum);
        maxSumFoundYet = Math.max(maxSumFoundYet, root.val + leftMaxSum + rightMaxSum);

        return maxSum;
    }
}
