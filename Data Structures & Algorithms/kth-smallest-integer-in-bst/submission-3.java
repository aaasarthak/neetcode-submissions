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
    List<Integer> sortedList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;

        var result = kthSmallest(root.left, k);
        if(result != -1) return result;
        sortedList.add(root.val);
        if(sortedList.size() == k) return sortedList.getLast();
        result = kthSmallest(root.right, k);
        if(result != -1) return result;

        return -1;
    }
}
