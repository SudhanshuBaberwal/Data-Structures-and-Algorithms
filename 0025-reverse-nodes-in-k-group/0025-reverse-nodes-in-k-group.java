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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (true) {
            ListNode curr = prev;
            for (int i = 0; i < k; i++) {
                curr = curr.next;
                if (curr == null) {
                    return dummy.next;
                }
            }
            ListNode groupNext = curr.next;
            ListNode groupPrev = groupNext;
            curr = prev.next;
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = groupPrev;
                groupPrev = curr;
                curr = next;
            }
            ListNode oldGroupStart = prev.next;
            prev.next = groupPrev;
            prev = oldGroupStart;
        }
    }
}