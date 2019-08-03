package com.company;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class TestDeque {

    @Test
    public void testIsEmpty() {
        Deque deque = new Deque();
        assertTrue(deque.isEmpty());
        deque.addFirst(1);
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testSize() {
        Deque<String> deque = new Deque<String>();

        deque.addFirst("s");
        deque.addFirst("s");
        deque.addLast("s");
        assertEquals(3, deque.size());
        deque.removeLast();
        assertEquals(2, deque.size());
        deque.addLast("s");
        deque.removeLast();
        deque.removeFirst();
        assertEquals(1, deque.size());
        deque.removeFirst();
        assertEquals(0, deque.size());
    }

    @Test
    public void testAddFirst() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        Integer expectedFirst = 1;

        int count = 0;
        for (Integer item: deque) {
            if (count == 0)
                assertEquals(expectedFirst, item);
        }

        deque.addFirst(2);
        expectedFirst = 2;
        for (Integer item: deque) {
            if (count == 0)
                assertEquals(expectedFirst, item);
            if (count == 1)
                assertEquals((Integer)1, item);
            count++;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFirst_ParameterNull_Exception() {
        Deque deque = new Deque();
        deque.addFirst(null);
    }

    @Test
    public void testAddLast() {
        Deque deque = new Deque();
        deque.addLast(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        // first item should be 2
        int removed = (int)deque.removeLast();
        int expected = 4;
        assertEquals(expected, removed);

        removed = (int)deque.removeLast();
        expected = 3;
        assertEquals(expected, removed);

        removed = (int)deque.removeLast();
        expected = 1;
        assertEquals(expected, removed);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddLast_ParameterNull_Exception() {
        Deque deque = new Deque();
        deque.addLast(null);
    }

    @Test
    public void testRemoveFirst() {
        Deque deque = new Deque();
        deque.addLast(1);
        deque.addFirst(2);
        // first item should be 2
        int removed = (int)deque.removeFirst();
        int expected = 2;
        assertEquals(expected, removed);

        removed = (int)deque.removeFirst();
        expected = 1;
        assertEquals(expected, removed);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirst_DequeEmpty_Exception() {
        Deque deque = new Deque();
        deque.addLast(1);
        deque.addFirst(1);
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
    }

    @Test
    public void testRemoveLast() {
        Deque deque = new Deque();
        deque.addLast(1);
        deque.addFirst(2);
        int last = (int) deque.removeLast();

        assertEquals(1, last);
        last = (int) deque.removeLast();
        assertEquals(2, last);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLast_DequeEmpty_Exception() {
        Deque deque = new Deque();
        deque.addLast(1);
        deque.addFirst(2);
        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
    }

    @Test
    public void testGetIterator() {
        Deque deque = new Deque();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(4);
        deque.addLast(5);
        Iterator iterator = deque.iterator();
        int value  =  (int) iterator.next();
        assertEquals(1, value);
        value =  (int) iterator.next();
        assertEquals(2, value);

        value =  (int) iterator.next();
        assertEquals(3, value);
        value =  (int) iterator.next();
        assertEquals(4, value);
        value =  (int) iterator.next();
        assertEquals(5, value);

    }


    @Test(expected = NoSuchElementException.class)
    public void testNext_NoMoreElement_Exception() {
        Deque deque = new Deque();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        Iterator iterator = deque.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNext_IteratorRemove_Exception() {
        Deque deque = new Deque();
        deque.addFirst(3);

        Iterator iterator = deque.iterator();
        iterator.remove();
    }


}
