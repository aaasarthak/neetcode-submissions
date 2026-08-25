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
        ListNode resultList = null;
        ListNode curr = null;
        
        while(list1 != null || list2 != null) {
            if(resultList == null) {
                resultList = new ListNode();
                curr = resultList;
            } else {
                ListNode next = new ListNode();
                curr.next = next;
                curr = curr.next;
            }

            if(list1 != null && list2 != null) {
                curr.val = list1.val < list2.val ? list1.val : list2.val;
                if(list1.val < list2.val) {
                    list1 = list1.next;
                } else {
                    list2 = list2.next;
                }
            } else {
                curr.val = list1 == null ? list2.val : list1.val;
                if(list1 == null) {
                    list2 = list2.next;
                } else {
                    list1 = list1.next;
                }
            }
        }
        
        return resultList;
    }
}