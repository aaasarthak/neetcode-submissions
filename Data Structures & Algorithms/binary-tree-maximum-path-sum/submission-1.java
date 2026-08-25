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
    int maxSum = -1001;

    public int maxPath(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftSum = Math.max(maxPath(root.left), 0);
        int rightSum = Math.max(maxPath(root.right), 0);

        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        return Math.max(root.val + leftSum, root.val + rightSum);
    }

    public int maxPathSum(TreeNode root) {
        maxPath(root);

        return maxSum;
    }
}
