/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(0, null);
        ListNode resultHead = dummyNode;

        while(true) {
            int smallestValue = 1001;
            int smallestNodeIndex = -1;
            boolean isAllNull = true;
            for(int i=0; i<lists.length; i++) {
                if(lists[i] != null) {
                    isAllNull = false;
                }

                if(lists[i] != null && lists[i].val < smallestValue) {
                    smallestNodeIndex = i;
                    smallestValue = lists[i].val;
                }
            }
    
            if(isAllNull) {
                break;
            }
            resultHead.next = lists[smallestNodeIndex];
            resultHead = resultHead.next;
            lists[smallestNodeIndex] = lists[smallestNodeIndex].next;
        }

        return dummyNode.next;

    }
}
