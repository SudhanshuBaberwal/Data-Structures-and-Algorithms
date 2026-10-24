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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right){
            return head;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.val = -1;
        dummyNode.next = head;

        ListNode prev = dummyNode;
        for (int i=1; i< left; i++){
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode prevSub = null;
        ListNode n = null;

        for (int i= left ; i<=right ; i++){
            n = curr.next;
            curr.next = prevSub;
            prevSub = curr;
            curr = n;
        }
        prev.next.next = curr;
        prev.next = prevSub;

        return dummyNode.next;
    }
}