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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return List.of();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> resultList = new ArrayList<>();
        while(!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int currentSize = queue.size();
            for(int i=0; i<currentSize; i++) {
                var node = queue.poll();
                levelList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            resultList.add(levelList);
        }

        return resultList;
    }
}
