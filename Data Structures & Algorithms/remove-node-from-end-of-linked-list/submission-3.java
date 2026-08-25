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
        ListNode lead = head.next, lag = head;
        while(lead != null) {
            if(n == 0) {
                lag = lag.next;
            } else {
                n--;
            }

            lead = lead.next;
        }

        if(lag == head && n == 0) {
            head.next = head.next.next;
            return head;
        } else if(lag == head && n != 0) {
            return head.next;
        } else {
            lag.next = lag.next.next;
            return head;
        }        
    }
}
