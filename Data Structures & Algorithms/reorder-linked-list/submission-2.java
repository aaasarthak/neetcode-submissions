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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        second = prev;
        ListNode start = head;
        while(second != null) {
            ListNode secondNext = second.next;
            ListNode headNext = start.next;
            start.next = second;
            second.next = headNext;
            second = secondNext;
            start = headNext;
        }
    }
}
