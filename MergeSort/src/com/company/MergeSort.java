package com.company;

import java.util.Comparator;

// Use my own implementation, I think my implementation is better
public class MergeSort {

    public static void sort(Object[] a, Comparator comparator) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1, comparator);
    }

    public static void sort(Object[] a, Object[] aux, int low, int high, Comparator c) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2; // to avoid stack overflow
        sort(a, aux, low, mid, c);
        sort(a, aux, mid + 1, high, c);
        merge(a, aux, low, mid, high, c);
    }

    // todo turn off assertion at production java -ea Program or java -da Program
    // replace a[] with sorted aux[]
    public static void merge(Object[] a, Object[] aux, int low, int mid, int high, Comparator c) {
        assert isSorted(a, low, mid, c);
        assert isSorted(a, mid, high, c);

        int size = a.length;
        // make a auxiliary array
        for (int i = 0; i < size; i++) {
            aux[i] = a[i];
        }

        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            // if all items in low bound are exhausted, copy j to a[]
            if (i > mid) {
                a[k] = aux[j++];
            }
            // if all items in high bounds are gone, copy i to a[]
            else if (j < mid) {
                a[k] = aux[j--];
            }
            //
            else if (less(aux[i], aux[j], c)) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
        assert isSorted(a, low, high, c);
    }

    // ensure the part of array given is sorted
    private static boolean isSorted(Object[] a, int low, int high, Comparator c) {
        for (int i = low; i < high - 1; i++)
            if (!less(a[i], a[i + 1], c))
                return false;
        return true;
    }

    // ensure the part of array given is sorted
    private static boolean less(Object a, Object b, Comparator c) {
        return c.compare(a, b) < 0;
    }

}
