package practices.waterball.adt;

import dsa.adt.*;


public class WbAdtFactory implements AdtFactory {

    @Override
    public ArrayStack createArrayStack(int maxSize) {
        return new WbArrayStack(maxSize);
    }

    @Override
    public LinkedListStack createLinkedListStack() {
        return new WbLinkedListStack();
    }

    @Override
    public MultipleStack createDoubleStack(int maxSize) {
        return new WbDoubleStack(maxSize);
    }

    @Override
    public MultipleStack createMultipleStack(int stackCount, int maxSize) {
        return new WbMultipleStack(stackCount, maxSize);
    }

    @Override
    public Queue createCircularArrayQueue(int maxSize) {
        return new WbCircularArrayQueue(maxSize);
    }

    @Override
    public Queue createSingleLinkedListQueue() {
        return new WbSingleLinkedListQueue();
    }

    @Override
    public Queue createCircularLinkedListQueue() {
        return new WbCircularLinkedListQueue();
    }

    @Override
    public SingleLinkedList createSingleLinkedList() {
        return new WbSingleLinkedList();
    }

    @Override
    public LinkedList createCircularLinkedList() {
        return new WbCircularLinkedList();
    }

    @Override
    public LinkedList createDoubleLinkedList() {
        return new WbDoubleLinkedList();
    }

    @Override
    public BSTree createBStree() {
        return new WbThreadBSTree();
    }

    @Override
    public MinHeap createMinHeap() {
        return new WbMinHeap();
    }

    @Override
    public DisjointSet createDisjointSet() {
        return new WbArrayDisjointSet();
    }
}
