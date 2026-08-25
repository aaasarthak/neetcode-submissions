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
    int index = -1;
    List<Integer> inOrderList = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return -1;
        }
        
        kthSmallest(root.left, k);
        inOrderList.add(root.val);
        kthSmallest(root.right, k);

        if(inOrderList.size() >= k) {
            return inOrderList.get(k-1);
        } else {
            return -1;
        }
    }
}
