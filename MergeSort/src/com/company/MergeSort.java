package com.company;

// Use my own implementation, I think my implementation is better
public class MergeSort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, Comparable[] aux, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2; // to avoid stack overflow
        sort(a, aux, low, mid);
        sort(a, aux, mid + 1, high);
        merge(a, aux, low, mid, high);
    }

    // todo turn off assertion at production java -ea Program or java -da Program
    // replace a[] with sorted aux[]
    public static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high) {
        assert isSorted(a, low, mid);
        assert isSorted(a, mid, high);

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
            else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
        assert isSorted(a, low, high);
    }

    // ensure the part of array given is sorted
    private static boolean isSorted(Comparable[] a, int low, int high) {
        for (int i = low; i < high - 1; i++)
            if (!less(a[i], a[i + 1]))
                return false;
        return true;
    }

    // ensure the part of array given is sorted
    private static boolean less(Comparable a, Comparable b) {
        return true;
    }

}
