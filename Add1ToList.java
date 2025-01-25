class Solution {
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        Node curr = head;
        int carry = 1;
        while (curr != null) {
            curr.data = curr.data + carry;
            if (curr.data < 10) {
                carry = 0;
                break;
            } else {
                curr.data = 0;
                carry = 1;
            }
            curr = curr.next;
        }
        head = reverse(head);
        if (carry == 1) {
            Node temp = new Node(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}