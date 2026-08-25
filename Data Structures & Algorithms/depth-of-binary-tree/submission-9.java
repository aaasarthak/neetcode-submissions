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
    int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int depth = 1;
        depth = depth + Math.max(maxDepth(root.left), maxDepth(root.right));
        return depth;
    }
}
