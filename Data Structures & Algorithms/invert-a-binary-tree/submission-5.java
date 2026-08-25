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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode head = queue.poll();
            TreeNode temp = head.left;
            head.left = head.right;
            head.right = temp;

            if(head.left != null) {
                queue.add(head.left);
            } 
            
            if(head.right != null) {
                queue.add(head.right);
            }
            
        }

        return root;
    }
}
