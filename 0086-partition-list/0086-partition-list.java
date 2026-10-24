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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        ListNode d1 = small;
        ListNode d2 = large;

        ListNode curr = head;
        while (curr!=null){
            if (curr.val<x){
                d1.next = curr;
                d1 = d1.next;
            }
            else{
                d2.next=curr;
                d2=d2.next;
            }
            curr=curr.next;
        }
        d2.next = null;
        d1.next=large.next;
        return small.next;
    }
}