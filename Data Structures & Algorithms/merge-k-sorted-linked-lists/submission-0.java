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
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));
        ListNode resultHead = null;
        ListNode resultCurrent = null;
        while(!listNodes.isEmpty()) {
            int minimum = 1001;
            ListNode minimumHead = null;
            int index = -1;

            for(int i = 0; i < listNodes.size(); i++) {
                if(listNodes.get(i).val < minimum) {
                    minimum = listNodes.get(i).val;
                    index = i;
                }
            }
            listNodes.set(index, listNodes.get(index).next);

            if(resultHead == null) {
                resultHead = new ListNode(minimum);
                resultCurrent = resultHead;
            } else {
                resultCurrent.next = new ListNode(minimum);
                resultCurrent = resultCurrent.next;
            }

            listNodes.removeIf(list -> list == null);
        }

        return resultHead;
    }
}
