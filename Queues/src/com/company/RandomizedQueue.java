package com.company;

import org.omg.CORBA.Object;

import java.util.Iterator;
import java.util.Random;
/*
This an array implementation Randomized Queue
Specification: https://coursera.cs.princeton.edu/algs4/assignments/queues/specification.php
 */
public class RandomizedQueue<Item> implements Iterable<Item> {


    private static final Random gen = new java.util.Random();


    private Item[] queue;
    private int size = 0;

    // construct an empty randomized queue
    public RandomizedQueue(){}

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    // as index always increase after adding an item, it's the reflection of size
    public int size() {
        return size;
    }

    // add the item, add item then increase the index value
    public void enqueue(Item item) {
        if (size == queue.length)
            resize(size * 2);
        queue[size++] = item; // do the operation first and increase the number
    }

    private void resize(int capacity) {
        // copy the items from the previous queue
        Item[] newQueue = (Item[])new Object[capacity];
        for (int i = 0; 0 < queue.length; i++) {
            newQueue[i] = queue[i];
        }
        queue = newQueue;
    }

    // remove and return a random item
    public Item dequeue() {
        shuffle(); // shuffle the queue and then remove the last one
        // queue is less then half full, resize to 3 quarter of the size
        if (size < queue.length / 2) {
            resize(queue.length / 4 * 3);
        }
        return queue[--size];
    }

    // important to shuffle from i to size not 0 to size
    private void shuffle() {
        for ( int i = 0; i < size; i++) {
            int r = gen.nextInt(i + 1); // random(1) never gets 1
            swap(i, r);
        }
    }

    private void swap(int i, int j) {
        Item tempA = queue[i];
        queue[i] = queue[j];
        queue[j] = tempA;
    }

    // return a random item (but do not remove it)
    // not sure if this is completely un biased random
    public Item sample() {
        return queue[gen.nextInt(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {}


    private class RandomizedQueueIterator implements Iterator<Item> {

        public Item next() {
            return null;
        }

        public boolean hasNext() {
            return false;
        }
    }
}
