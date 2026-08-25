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
        if(p == null && q == null) {
            return true;
        }
        
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();

        queueP.offer(p);
        queueQ.offer(q);

        while(!queueP.isEmpty() || !queueQ.isEmpty()) {
            int sizeP = queueP.size();
            int sizeQ = queueQ.size();

            if(sizeP != sizeQ) {
                return false;
            } 

            for(int i = 0; i < sizeP; i++) {
                TreeNode pollP = queueP.poll();
                TreeNode pollQ = queueQ.poll();
                if(pollP == null && pollQ == null) {
                    continue;
                } 

                if(pollP == null || pollQ == null) {
                    return false;
                }

                if(pollP.val != pollQ.val) {
                    return false;
                }

                if(pollP != null) {
                   queueP.offer(pollP.left);
                   queueP.offer(pollP.right);
                }
                if(pollQ != null) {
                    queueQ.offer(pollQ.left);
                    queueQ.offer(pollQ.right);
                }
            }
        }

        return true;
    }
}
