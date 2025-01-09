public class Implementation {
    public static class Node {
        int data;
        Node next;

        Node(int d, Node ptr) {
            this.data = d;
            this.next = ptr;
        }

        Node(int d) {
            this.data = d;
            this.next = null;
        }

    }

    private static Node arrayToList(int arr[]) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            curr.next = temp;
            curr = curr.next;
        }
        return head;
    }

    private static void Traversal(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }

    private static int getLength(Node head) {
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    private static Node removeHead(Node head) {
        return head.next;
    }

    private static Node removeTail(Node head) {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removePosition(Node head, int pos) {
        if (head == null)
            return head;
        if (pos == 1)
            return removeHead(head);
        int k = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            k++;
            if (k == pos) {
                prev.next = temp.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node insertHead(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        return temp;
    }

    private static Node insertTail(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            return temp;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = temp;
        return head;
    }

    private static Node insertPosition(Node head, int data, int pos) {
        if (head == null) {
            if (pos == 1) {
                return new Node(data);
            }
        }
        if (pos == 1) {
            return new Node(data);
        }
        int k = 0;
        Node temp = head;
        while (temp != null) {
            k++;
            if (k == pos - 1) {
                Node newNode = new Node(data);
                newNode.next = temp.next;
                temp.next = newNode;

            }
            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        Node head = arrayToList(arr);
        // Traversal(head);
        // System.out.println("length is " + getLength(head));
        // // head = removeHead(head);
        // Traversal(head);
        // head = removeTail(head);
        // Traversal(head);
        // head = removePosition(head, 3);
        // head = insertHead(head, 100);
        // head = insertTail(head, 25);
        head = insertPosition(head, 34, 4);
        Traversal(head);
    }
}