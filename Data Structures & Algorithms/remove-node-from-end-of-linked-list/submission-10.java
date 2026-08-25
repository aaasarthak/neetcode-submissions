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
        if(head == null || (head.next == null && n == 1)) return null;

        int index = remove(head, n);
        if(index == 1) {
            return head.next;
        }
        return head;
    }

    private int remove(ListNode head, int n) {
        if(head.next == null) {
            return n;
        }

        int index = remove(head.next, n) - 1;

        if(index == 0) {
            head.next = head.next.next;
            index--;
        }

        return index;
    }
}
