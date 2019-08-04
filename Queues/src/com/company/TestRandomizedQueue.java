package com.company;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

public class TestRandomizedQueue {

    @Test
    public void testIsEmpty() {
        assertTrue(false);
    }


    @Test
    public void testSize() {
        assertTrue(false);
    }

    @Test
    public void testEnquque() {
        assertTrue(false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEnquque_ParameterNull_Exception() {

    }

    @Test
    public void testDequque() {
        assertTrue(false);
    }


    @Test(expected = NoSuchElementException.class)
    public void testDequeue_Empty_Exception() {

    }

    @Test
    public void testSample() {
        assertTrue(false);
    }


    @Test(expected = NoSuchElementException.class)
    public void testSample_Empty_Exception() {

    }


    @Test
    public void testIterator() {
        assertTrue(false);
    }


    @Test(expected = NoSuchElementException.class)
    public void testIteratorNext_NoMore_Exception() {

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemote_NoMore_Exception() {

    }
}
