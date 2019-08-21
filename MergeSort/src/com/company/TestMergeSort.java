package com.company;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TestMergeSort {

    @Test
    public void testMergeSort() {
        Comparable[] unsorted = new Comparable[10];
        BottomUpMergeSort.sort(unsorted);
        assertTrue(sorted(unsorted));
    }

    private boolean sorted(Comparable[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

}
