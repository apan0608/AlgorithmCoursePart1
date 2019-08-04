package com.company;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestRandomizedQueue {

    private static RandomizedQueue _queue = new RandomizedQueue();
    @Test
    public void testIsEmpty() {

        RandomizedQueue queue = _queue;

        // is empty to start with
        assertTrue(queue.isEmpty());
        // not empty after adding
        queue.enqueue("2");
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }


    @Test
    public void testSize() {
        RandomizedQueue queue = _queue;

        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());

        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        assertEquals(5, queue.size());

        queue.dequeue();
        assertEquals(4, queue.size());
        queue.dequeue();
        assertEquals(3, queue.size());
        queue.dequeue();
        assertEquals(2, queue.size());
        queue.dequeue();
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void testEnqueue() {
        RandomizedQueue queue = _queue;

        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnqueue_ParameterNull_Exception() {
        RandomizedQueue queue = _queue;
        queue.enqueue(null);
    }

    @Test
    public void testDequeue() {
        String[] items = new String[] {
                "1", "2", "3", "4", "5", "6",  "7", "8", "9", "10" };

        RandomizedQueue queue = new RandomizedQueue<String>();
        for (String item: items) {
            queue.enqueue(item);
        }
        // dequeued value is one of the numbers above
        String value1 = (String) queue.dequeue();
        assertTrue(Arrays.stream(items).anyMatch(x -> x.equals(value1)));
        String value2 = (String) queue.dequeue();
        String value3 = (String) queue.dequeue();

        // the dequeued values are not in the same order as added, chances are 0.0013 percentage
        assertFalse(value1.equals("10") && value2.equals("9")  && value3.equals("8"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeue_Empty_Exception() {
        RandomizedQueue queue = _queue;
        queue.enqueue(1);
        queue.dequeue();
        queue.dequeue();
    }

    @Test
    public void testSample() {
        String[] items = new String[] {
                "1", "2", "3", "4", "5", "6",  "7", "8", "9", "10" };

        RandomizedQueue queue = new RandomizedQueue<String>();
        for (String item: items) {
            queue.enqueue(item);
        }
        // dequeued value is one of the numbers above
        String value1 = (String) queue.dequeue();
        String value2 = (String) queue.dequeue();
        String value3 = (String) queue.dequeue();

        // the dequeued values are not in the same order as added, chances are 0.0013 percentage
        assertFalse(value1.equals(value2) && value2.equals(value3));
    }

    @Test(expected = NoSuchElementException.class)
    public void testSample_Empty_Exception() {
        _queue.sample();
    }

    @Test
    public void testIterator() {
        RandomizedQueue queue = _queue;
        Iterator iterator = queue.iterator();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        int value1 = (Integer) iterator.next();
        int value2 = (Integer)iterator.next();
        int value3 = (Integer)iterator.next();
        int value4 = (Integer)iterator.next();

        assertFalse(value1 == 1 && value2 == 2 && value3 == 3 && value4 ==1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNext_NoMore_Exception() {
        RandomizedQueue queue = _queue;
        Iterator iterator = queue.iterator();
        queue.enqueue(1);
        queue.enqueue(2);
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove_NoMore_Exception() {
        RandomizedQueue queue = _queue;
        Iterator iterator = queue.iterator();
        queue.enqueue(1);
        queue.enqueue(2);
        iterator.remove();
    }
}
