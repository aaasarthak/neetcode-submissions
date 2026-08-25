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
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode prev = null;
        ListNode temp = null;

        while(true) {
            temp = head.next;
            head.next = prev;
            prev = head;

            if(temp == null) {
                break;
            }
            head = temp;
        }

        return head;
    }
}
