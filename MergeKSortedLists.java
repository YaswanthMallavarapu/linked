/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 == null)
            temp.next = temp2;
        else
            temp.next = temp1;
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        // ListNode head=lists[0];
        // for(int i=1;i<lists.length;i++){
        // head=merge(head,lists[i]);
        // }
        // return head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            temp.next = curr;
            temp = temp.next;
            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return dummy.next;
    }
}