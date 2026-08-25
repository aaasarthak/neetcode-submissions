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
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while(!stack.isEmpty()) {
            TreeNode pNode = stack.pop();
            TreeNode qNode = stack.pop();

            if(pNode != null || qNode != null) {
                if((pNode == null && qNode != null) || (pNode != null && qNode == null) 
                    || pNode.val != qNode.val) {
                    return false;
                }
            }
          
            if(pNode != null) {
                stack.push(pNode.left);
            }
            if(qNode != null) {
                stack.push(qNode.left);
            }


            if(pNode != null) {
                stack.push(pNode.right);
            }
            if(qNode != null) {
                stack.push(qNode.right);
            }
        }

        return true;
    }
}
