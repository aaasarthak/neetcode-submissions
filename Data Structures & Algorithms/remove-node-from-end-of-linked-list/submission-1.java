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
        ListNode slow = head;
        ListNode fast = head;
        ListNode headClone = head;
        int count = 0;

        for(int i = 0; headClone != null; i++, count++) {
            if(i > n) {
                slow = slow.next;
            }
            fast = fast.next;
            headClone = headClone.next;
        }

        if(count == n) {
            head = head.next;
        } else {
            slow.next = slow.next.next;
        }

        return head;
    }
}
