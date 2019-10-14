package com.quicksort;

public class QuickSort {

    public static void main(String args[]) {
        
    }

    // todo or can also pass in Comparator with Object[] other than using Comparable[],
    public static void sort(Comparable[] unsorted) {
        // todo shuffle first
        // todo replace quick sort with insertion sort when array size is less than 10 items
        sort(unsorted, 0, unsorted.length - 1);
    }

    private static void sort(Comparable[] unsorted, int low, int hi) {
        if (hi <= low) return;

        int j = partition(unsorted, low, hi);

        sort(unsorted, low, j - 1);
        sort(unsorted, j + 1, hi);
    }

    private static int partition(Comparable[] unsorted, int lo, int hi) {
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

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exchange(Comparable[] unsorted, int i, int j) {
        Comparable reserved = unsorted[i];
        unsorted[i] = unsorted[j];
        unsorted[j] = reserved;
    }
}