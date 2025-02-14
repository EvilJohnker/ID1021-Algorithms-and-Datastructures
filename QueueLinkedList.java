public class QueueLinkedList {
    Node head;
    Node tail;
    private class Node {
        Integer item;
        Node next;
        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }
    }
    public QueueLinkedList() {
        head = null;
        tail = null;
    }
    public void enqueue(Integer item) {

        if (head == null) head = new Node(item, null);
        else {
            Node nd = head;
            while (nd.next != null) nd = nd.next;
            nd.next = new Node(item, null);
        }

        /*
        if (head == null) {
            head = new Node(item, null);
            tail = head;
        }
        else {
            tail.next = new Node(item, null);
            tail = tail.next;
        }
        */
    }
    public Integer dequeue() {
        if (head == null) return null;
        Integer val = head.item;
        head = head.next;
        return val;
    }
}

