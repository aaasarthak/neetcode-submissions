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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

        //finding the subroot in the root and then checking the subtree is same or not
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.val == subRoot.val && checkIfTheSubtreeIsSame(node, subRoot)) {
                return true;
            }

            if(node.left != null) {
                stack.push(node.left);
            }

            if(node.right != null) {
                stack.push(node.right);
            }
        }

        return false;
    }

    private boolean checkIfTheSubtreeIsSame(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }

        if(root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return checkIfTheSubtreeIsSame(root.left, subRoot.left) && checkIfTheSubtreeIsSame(root.right, subRoot.right);
    }
}
