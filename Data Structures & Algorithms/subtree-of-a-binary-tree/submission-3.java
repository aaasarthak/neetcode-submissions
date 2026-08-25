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

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isSubTreeFound = false;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if(node.val == subRoot.val) {
                isSubTreeFound = compareTree(node, subRoot);
            }

            if(isSubTreeFound) {
                return true;
            }

            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        return false;
    }

    private boolean compareTree(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) {
            return true;
        }

        if(tree1 == null || tree2 == null || tree1.val != tree2.val) {
            return false;
        }

        return compareTree(tree1.left, tree2.left) && 
            compareTree(tree1.right, tree2.right);

    }
}
