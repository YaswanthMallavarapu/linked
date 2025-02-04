// User function Template for Java

/* Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                if (temp == head) {
                    head = head.next;
                    temp.next.prev = null;
                }
                Node prev = temp.prev;
                Node next = temp.next;
                if (prev != null)
                    prev.next = next;
                if (next != null)
                    next.prev = prev;
                temp = next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}