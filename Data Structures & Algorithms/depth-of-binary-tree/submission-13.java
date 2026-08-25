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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode head = queue.poll();
                if(head.left != null || head.right != null) {
                    if(head.left != null) {
                        queue.offer(head.left);
                    }

                    if(head.right != null) {
                        queue.offer(head.right);
                    }
                }
            }

            if(!queue.isEmpty()) {
                level++;
            }
        }

        return level;
    }
}
