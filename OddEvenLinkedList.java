public class OddEvenLinkedList {

}

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
    public ListNode oddEvenList(ListNode head) {
        // if(head==null)return head;
        // List<Integer>data=new ArrayList<>();
        // ListNode curr=head;
        // while(curr!=null && curr.next!=null){
        // data.add(curr.val);
        // curr=curr.next.next;
        // }
        // if(curr!=null)data.add(curr.val);
        // curr=head.next;
        // while(curr!=null && curr.next!=null){
        // data.add(curr.val);
        // curr=curr.next.next;
        // }
        // if(curr!=null)data.add(curr.val);
        // curr=head;
        // for(int a:data){
        // curr.val=a;
        // curr=curr.next;
        // }return head;
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;

    }
}