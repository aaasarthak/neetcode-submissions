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
        ListNode dummy = new ListNode(0, head);
        ListNode lead = head, lag = dummy;
        while(lead != null) {
            if(n == 0) {
                lag = lag.next;
            } else {
                n--;
            }

            lead = lead.next;
        }

        lag.next = lag.next.next; 
        return dummy.next;     
    }
}
