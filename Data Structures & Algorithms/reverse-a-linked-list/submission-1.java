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

        ListNode oldHead = head;
        ListNode next = head.next;
        ListNode prev = head;
        head = head.next;
        while(next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        oldHead.next = null;
        return prev;
    }
}
