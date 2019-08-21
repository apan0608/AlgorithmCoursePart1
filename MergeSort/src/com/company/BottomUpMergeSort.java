package com.company;

public class BottomUpMergeSort {

    // without using recursive
    // first round: 0,1 | 2,3 | 4,5 | 6,7 |
    // second round: 0,3 | 4,7 | 8,11|
    // third round: 0,7 | 8,15 | 16, 23 |
    public static void sort(Comparable[] a) {
        for(int i = 1; i <= a.length - 1; i *= 2) {
            for(int j = 0; j < a.length - i; j += i + i) {
                sort(a, j, j + i - 1,  Math.min(j + i - 1, a.length - 1)); // if it reaches the last item
            }
        }
    }

    public static void sort(Comparable[] a, int low, int mid, int high) {
        int length = high - low + 1;
        Comparable[] aux = new Comparable[length];
        // copy items from a to aux
        for (int k = 0; k < length; k++) {
            aux[k] = a[k + low];
        }
        int i = low;
        int j = mid + 1;
        // loop till all items are copied across
        for (int count = low; count < high; count++) {
            if (a[i].compareTo(a[j]) <= 0) {
                // in order, then copy i to aux
                a[i++] = aux[count];
            } else {
                a[j++] = aux[count];
            }
        }
        // after sorted, aux will copy back to original array
        for (i = 0; i < aux.length; i++) {
            a[i + low] = aux[i];
        }
    }
}
