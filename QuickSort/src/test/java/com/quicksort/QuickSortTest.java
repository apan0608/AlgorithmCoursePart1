package com.quicksort;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        Integer[] unsorted = new Integer[] {1, 2, 3, 4, 5};
        QuickSort.sort(unsorted);
    }

    @Test
    public void testCompareTo() {
        Integer a = 1;
        Integer b = 2;
        int result = a.compareTo(b);
        assertTrue(result < 0);
        a = 3;
        result = a.compareTo(b);
        assertTrue(result > 0);
        a = 2;
        result = a.compareTo(b);
        assertTrue(result == 0);

    }
}