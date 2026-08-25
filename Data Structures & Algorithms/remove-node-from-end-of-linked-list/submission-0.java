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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        while(head != null) {
            listNodes.add(head);
            head = head.next;
        }

        int index = listNodes.size() - n;
        if(index == 0) {
            head = listNodes.get(0).next;
        } else {
            listNodes.get(index - 1).next = listNodes.get(index).next;
            head = listNodes.get(0);
        }
        return head;
    }
}
