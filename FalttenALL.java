class Solution {
    public static Node merge(Node head,Node temp){
        Node one=head;
        Node two=temp;
        Node demo=new Node(-1);
        Node temp1=demo;
        while(one!=null && two!=null){
            if(one.data<two.data){
                temp1.bottom=one;
                one=one.bottom;
            }
            else{
                temp1.bottom=two;
                two=two.bottom;
            }
            temp1=temp1.bottom;
        }
        if(one!=null)temp1.bottom=one;
        else temp1.bottom=two;
        return demo.bottom;
    }
    // Function to flatten a linked list
    Node flatten(Node root) {
        Node temp=root.next;
        Node head=root;
        while(temp!=null){
            head=merge(head,temp);
            temp=temp.next;
        }
        return head;
    }
}