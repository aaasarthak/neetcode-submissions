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
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int level = 0;
        traverse(root, resultList, level);
        return resultList;
    }

    private void traverse(TreeNode root, List<List<Integer>> resultList, int level) {
        if(root == null) {
            return;
        }

        try {
            resultList.get(level);
        } catch(IndexOutOfBoundsException ex) {
            resultList.add(new ArrayList<Integer>());
        }
        resultList.get(level).add(root.val);
        traverse(root.left, resultList, level + 1);
        traverse(root.right, resultList, level + 1);
    }
}
