package com.quicksort;

public class QuickSort {

    public static void main(String args[]) {
        
    }

    public static void sort(Object[] unsorted) {
        // first randomly shuffle the array
    }

    private static void sort(Object[] unsorted, int low, int hi) {
        if (low == hi) return;

        int j = partition(unsorted, low, hi);

        sort(unsorted, low, j - 1);
        sort(unsorted, j + 1, hi);
    }

    private static int partition(Object[] unsorted, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (less(unsorted[++i], unsorted[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while ( less(unsorted[lo], unsorted[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(unsorted, i, j);
        }
        exchange(unsorted, lo, j);
        return j;
    }

    // todo implement comparison betwen a and b
    private static boolean less(Object a, Object b) {
//        return a < b;
        return true;
    }


    private static void exchange(Object[] unsorted, int i, int j) {
        // todo do the exchange here
    }
}