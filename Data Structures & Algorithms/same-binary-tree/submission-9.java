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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null || q == null) || (p.val != q.val)) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while(!stack.isEmpty()) {
            TreeNode pNode = stack.pop();
            TreeNode qNode = stack.pop();
            
            if((pNode.left == null && qNode.left != null) || (pNode.left != null && qNode.left == null))
                return false;

            if(pNode.left != null && qNode.left != null) {
                if(pNode.left.val != qNode.left.val) return false;

                stack.push(pNode.left);
                stack.push(qNode.left);
            }

            if((pNode.right == null && qNode.right != null) || (pNode.right != null && qNode.right == null))
                return false;

            if(pNode.right != null && qNode.right != null) {
                if(pNode.right.val != qNode.right.val) return false;

                stack.push(pNode.right);
                stack.push(qNode.right);
            } 
            
        }

        return true;
    }
}
