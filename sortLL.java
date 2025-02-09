class Solution {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null;
        return slow;
    }
    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) temp.next = head1;
        if (head2 != null) temp.next = head2;

        return dummy.next;
    }

    public static ListNode sort(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = findMiddle(head);
        ListNode head1 = head;
        ListNode head2 = middle;
        head1 = sort(head1);
        head2 = sort(head2);

        return merge(head1, head2);
    }

    public ListNode sortList(ListNode head) {
        return sort(head);
    }
}
