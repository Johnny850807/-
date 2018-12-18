package practices.waterball.adt;

import dsa.adt.DoubleLinkedList;
import dsa.adt.LinkedList;

public class WbDoubleLinkedList extends DoubleLinkedList {
    private WbDoubleLinkNode head;

    @Override
    public LinkedList addHead(int item) {
        WbDoubleLinkNode node = new WbDoubleLinkNode(item);
        if (head == null)
        {
            head = node;
            head.next = head.previous = head;
        }
        else
        {
            WbDoubleLinkNode tail = head.previous;
            tail.next = node;
            node.previous = tail;
            node.next = head;
            head.previous = node;
            head = node;
        }
        return this;
    }

    @Override
    public LinkedList addTail(int item) {
        WbDoubleLinkNode node = new WbDoubleLinkNode(item);
        if (head == null)
        {
            head = node;
            head.next = head.previous = head;
        }
        else
        {
            WbDoubleLinkNode tail = head.previous;
            tail.next = node;
            node.previous = tail;
            head.previous = node;
            node.next = head;
        }
        return this;
    }

    @Override
    public int deleteHead() {
        if (head == null)
            throw new RuntimeException("Empty");
        int item = head.data;
        WbDoubleLinkNode tail = head.previous;
        head.next.previous = tail;
        tail.next = head.next;
        head = head.next;
        return item;
    }

    @Override
    public int deleteTail() {
        if (head == null)
            throw new RuntimeException("Empty");
        WbDoubleLinkNode tail = head.previous;
        int item = tail.data;
        tail.previous.next = head;
        head.previous = tail.previous;
        return item;
    }

    @Override
    public int delete(int index) {
        return 0;
    }

    @Override
    public LinkedList insert(int index, int item) {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        if (head == null)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (WbDoubleLinkNode n = head; n.next != head; n = n.next)
            stringBuilder.append(n.data).append(" ");
        stringBuilder.append(head.previous.data);
        return stringBuilder.toString();
    }
}