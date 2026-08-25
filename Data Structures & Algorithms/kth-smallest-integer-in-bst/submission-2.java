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
    public int kthSmallest(TreeNode root, int k) {
        // List<Integer> values = new ArrayList<>();
        // traverse(root, values);
        // values.sort((o1, o2) -> o1 - o2);
        // return values.get(k - 1);

        return traverse(root, k);
    }

    private void traverse(TreeNode root, List<Integer> values) {
        if(root == null) return;

        values.add(root.val);
        traverse(root.left, values);
        traverse(root.right, values);
    }

    private Integer traverse(TreeNode root, Integer k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<TreeNode> result = new ArrayList<>();

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            k--;
            if(k == 0) return curr.val;
            curr = curr.right;
            
        }

        return -1;
    }
}
