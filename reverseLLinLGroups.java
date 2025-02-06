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
    public static ListNode findkthnode(ListNode head,int k){
       k-=1;
       ListNode temp=head;
       while(temp!=null&&k!=0){
           k-=1;
           temp=temp.next;
       }
       return temp;
    }
    public static void reverse(ListNode head){
        ListNode prev=null,temp=head;
        while(temp!=null){
            ListNode next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode kthnode=findkthnode(temp,k);
            if(kthnode==null){
                if(prev!=null)prev.next=temp;
                break;
            }
            ListNode next=kthnode.next;
            kthnode.next=null;
            reverse(temp);
            if(temp==head)head=kthnode;
            else prev.next=kthnode;
            prev=temp;
            temp=next;
        }
        return head;
    }
}