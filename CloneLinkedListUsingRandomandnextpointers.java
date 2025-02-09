/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // if(head==null)return head;
        // HashMap<Node,Node>map=new HashMap<>();
        // Node temp=head;
        // while(temp!=null){
        // Node curr=new Node(temp.val);
        // map.put(temp,curr);
        // temp=temp.next;
        // }
        // temp=head;
        // Node dummy=new Node(-1);
        // Node res=dummy;
        // while(temp!=null){
        // Node curr=map.get(temp);
        // curr.next=map.get(temp.next);
        // curr.random=map.get(temp.random);
        // temp=temp.next;
        // res.next=curr;
        // res=res.next;
        // }
        // return dummy.next;
        Node temp = head;
        while (temp != null) {
            Node curr = new Node(temp.val);
            curr.next = temp.next;
            temp.next = curr;
            temp = temp.next.next;
        }
        temp = head;
        while (temp != null) {
            Node curr = temp.next;
            if (temp.random != null)
                curr.random = temp.random.next;
            else
                curr.random = null;
            temp = temp.next.next;
        }
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while (temp != null) {
            Node curr = temp.next;
            res.next = curr;
            temp.next = temp.next.next;
            temp = temp.next;
            res = res.next;
        }
        return dummy.next;
    }
}