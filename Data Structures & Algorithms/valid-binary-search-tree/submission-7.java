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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return (root.left == null || isValidBST(root.left, -1001, root.val)) && (root.right == null || isValidBST(root.right, root.val, 1001));
    }

    boolean isValidBST(TreeNode node, int minValue, int maxValue) {
        if(node.val <= minValue || node.val >= maxValue ) {
            return false;
        }

        return (node.left == null || isValidBST(node.left, minValue, node.val)) && (node.right == null || isValidBST(node.right, node.val, maxValue));
    }
}
