//User function Template for Java

class Solution {
    Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null) {
            Node temp1 = temp.next;
            while (temp1 != null && temp1.data == temp.data) {
                temp1 = temp1.next;
            }
            temp.next = temp1;
            if (temp1 != null)
                temp1.prev = temp;
            temp = temp.next;
        }
        return head;

    }
}