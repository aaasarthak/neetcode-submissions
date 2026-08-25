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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = null;
        ListNode resultHead = null;
        while(list1 != null || list2 != null) {
            //initializing the next list node and incrementing for next iteration
            ListNode nextListNode;
            if(list1 == null) {
                nextListNode = list2;
                list2 = list2.next;
            } else if(list2 == null) {
                nextListNode = list1;
                list1 = list1.next;
            } else {
                nextListNode = list1.val <= list2.val ? list1 : list2;
                if(list1.val <= list2.val) {
                    nextListNode = list1;
                    list1 = list1.next;
                } else {
                    nextListNode = list2;
                    list2 = list2.next;
                }
            }

            //Assigning values
            if(resultHead == null) {
                resultHead = nextListNode;
            }
            if(resultNode == null) {
                resultNode = nextListNode;
            } else {
                resultNode.next = nextListNode;
                resultNode = resultNode.next;
            }
        }

        return resultHead;
    }
}