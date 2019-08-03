package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 This class is implemented using linked list
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first = null;
    private Node last = null;
    private int size = 0; // not sure if I wanted this

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    } // another way is to loop through it


    // todo test how java reference type works
    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");

        Node newFirst = new Node(item);
        newFirst.next = first;
        first = newFirst;
        if (size == 0) {
            // first is the last
            last = first;
        }
        size++;
    }

    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item cannot be null");
        Node newNode = new Node(item);

        if (size == 0) {
            last = newNode;
            first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public Item removeFirst() {
        if (first == null)
            throw new NoSuchElementException("Item does not exist");

        Item oriFirstValue = first.item;

        if (size == 1) {
            first = null;
            last = null;
        } else {
            Node second  = first.next;
            first = second;
        }
        size--;
        return oriFirstValue;
    }

    public Item removeLast() {
        if (first == null)
            throw new NoSuchElementException("Item does not exist");

        Item lastValue = (Item) last.item;
        last = null;
        if (size == 1) {
            first = null;
        } else {
            Node node = first;
            while (node.next != null) {
                // this is the second last, make it the last
                if (node.next.next == null) {
                    node.next = null;
                    last = node;
                    break;
                }
                node = node.next;
            }
        }
        size--;
        return lastValue;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {

    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported in DequeIterator");
        }

        public Item next() {
            if (current.next == null)
                throw new NoSuchElementException("No more element in the collection");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next = null;
        // using previous will enhance the performance of remove last, but will make the implementation too complex

        public Node(Item item) {
            this.item = item;
        }
    }

}
