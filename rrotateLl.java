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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode temp = head;
        int len = 1;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        if (k % len == 0)
            return head;
        temp.next = head;
        k = k % len;
        k = len - k;
        int a = 1;
        ListNode temp1 = head;
        while (a != k) {
            a++;
            temp1 = temp1.next;
        }

        head = temp1.next;
        temp1.next = null;
        return head;
    }
}