package linkedlist;

public class DoublyLinkedListReverse {
    public static void main(String[] args) {
        DoublyLinkedListNode node1 = createData();

        printDoublyLinkedList(reverse(node1));
    }

    private static DoublyLinkedListNode createData() {
        DoublyLinkedListNode node4 = new DoublyLinkedListNode(4);
        DoublyLinkedListNode node2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode node1 = new DoublyLinkedListNode(1);
        node4.prev = node3;

        node3.next = node4;
        node3.prev = node2;

        node2.prev = node1;
        node2.next = node3;

        node1.next = node2;
        return node1;
    }

    private static void printDoublyLinkedList(DoublyLinkedListNode head) {
        System.out.print("null->");
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.print("null");

        System.out.println();
    }

    private static DoublyLinkedListNode reverse(DoublyLinkedListNode node1) {
        // creating two nodes next and prev
        // next has head's next
        // prev has head
        DoublyLinkedListNode next = node1.next;
        DoublyLinkedListNode prev = node1;
        prev.next = null;

        while (next != null) {
            // in every iteration, store next's next in a temp
            DoublyLinkedListNode temp = next.next;
            // replace next's previous with previous' previous
            next.prev = prev.prev;
            // previous' previous will be next node
            prev.prev = next;
            // next's next will be previous node
            next.next = prev;
            // now swapping is done, example, we have 2->1->null and 2<-3->4->null
            // in next iteration, current next becomes previous and temp becomes next
            prev = next;
            next = temp;
        }
        return prev;
    }
}
