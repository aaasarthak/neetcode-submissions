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
        ListNode resultList = new ListNode();
        ListNode dummyHead = resultList;

        while(list1 != null || list2 != null) {
            if(list1 == null) {
                resultList.next = list2;
                break;
            }
            if(list2 == null) {
                resultList.next = list1;
                break;
            }

            if(list1.val <= list2.val) {
                resultList.next = list1;
                list1 = list1.next;
            } else {
                resultList.next = list2;
                list2 = list2.next;
            }
            resultList = resultList.next;
        }

        return dummyHead.next;
    }
}