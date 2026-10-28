class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGroupTail = dummy;
        int groupSize = 1;
        while (prevGroupTail.next != null) {
            ListNode kth = prevGroupTail;
            int count = 0;
            while (count < groupSize && kth.next != null) {
                kth = kth.next;
                count++;
            }
            ListNode groupNext = kth.next;
            if (count % 2 == 0) {
                ListNode prev = groupNext;
                ListNode curr = prevGroupTail.next;
                while (curr != groupNext) {
                    ListNode nextNode = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextNode;
                }
                ListNode oldGroupHead = prevGroupTail.next;
                prevGroupTail.next = kth;
                prevGroupTail = oldGroupHead;
            } else {
                prevGroupTail = kth;
            }
            groupSize++;
        }
        return dummy.next;
    }
}
