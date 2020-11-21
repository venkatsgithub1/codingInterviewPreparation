package linkedlist;

public class DoublyLinkedListNode {

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }

    public DoublyLinkedListNode(int data, DoublyLinkedListNode next, DoublyLinkedListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;
}
