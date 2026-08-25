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
        int count = 0;
        List<ListNode> listNodes = new ArrayList<>();

        while(head != null) {
            count++;
            listNodes.add(head);
            head = head.next;
        }

        for(int i = 0, j = count - 1; i < (count - 1) / 2; i++, j--) {
            listNodes.get(j).next = listNodes.get(i).next;
            listNodes.get(i).next = listNodes.get(j);
        }

        listNodes.get(count / 2).next = null;
    }
}
