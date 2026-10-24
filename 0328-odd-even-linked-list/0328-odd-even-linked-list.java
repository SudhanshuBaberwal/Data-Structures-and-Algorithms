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
    public ListNode oddEvenList(ListNode head) {
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        ListNode d1 = first;
        ListNode d2 = second;
        ListNode curr = head;
        int i =0;
        while (curr!=null){
            if (i % 2 == 0){
                d1.next = curr;
                d1 = d1.next;
            }
            else{
                d2.next = curr;
                d2 = d2.next;
            }
            curr = curr.next;
            i++;
        }
        d2.next = null;
        d1.next = second.next;
        return first.next;
    }
}