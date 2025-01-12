class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data, Node prev, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private static Node convertToDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node curr = head;
        Node prev = null;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], prev, null);
            curr.next = temp;
            curr = curr.next;
            prev = temp;
        }
        return head;

    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();
    }

    private static Node deleteHead(Node head) {
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node head1 = head;
        Node head2 = head.next;
        while (head2.next != null) {
            head2 = head2.next;
            head1 = head1.next;
        }
        head1.next = null;
        head2.prev = null;
        return head;

    }

    private static Node deleteKPosition(Node head, int pos) {
        if (head == null)
            return head;
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == pos) {
                break;
            }
            curr = curr.next;
        }
        Node before = curr.prev;
        Node after = curr.next;
        if (before == null && after == null) {
            return null;
        } else if (before == null) {
            Node head1 = curr;
            curr = curr.next;
            head1.next = null;
            curr.prev = null;
            return curr;
        } else if (after == null) {
            before.next = null;
            curr.prev = null;
            return head;
        }
        before.next = after;
        after.prev = before;
        return head;

    }

    private static Node insertAtHead(Node head, int data) {
        if (head == null)
            return new Node(data);
        Node temp = new Node(data);
        head.prev = temp;
        temp.next = head;
        head = temp;
        return head;
    }

    private static Node insertTail(Node head, int data) {
        Node temp = new Node(data);
        if (head == null)
            return null;
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    private static Node insertAtPosition(Node head, int data, int pos) {
        Node temp = new Node(data);
        if (head == null && pos == 1)
            return temp;
        if (pos == 1) {
            return insertAtHead(head, data);
        }
        Node curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            if (count == pos) {
                curr.prev.next = temp;
                temp.prev = curr.prev;
                curr.prev = temp;
                temp.next = curr;
                return head;
            }
            curr = curr.next;
        }
        return head;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 3, 4, 5, 6 };
        Node head = convertToDLL(arr);
        print(head);
        // head = deleteHead(head);
        // head = deleteTail(head);
        // head = deleteKPosition(head, 6);
        // head = insertAtHead(head, 34);
        // head = insertTail(head, 10);
        head = insertAtPosition(head, 23, 5);
        print(head);
    }
}