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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if((p.val <= node.val && q.val >= node.val) || (p.val >= node.val && q.val <= node.val)) {
                return node;
            }

            if(p.val > node.val && q.val > node.val) {
                queue.add(node.right);
            } else {
                queue.add(node.left);
            }
        }

        return null;
    }
}
