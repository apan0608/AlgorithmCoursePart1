package com.quicksort;

import com.sun.media.sound.InvalidDataException;

/*
 Find the K th smallest item in hte array using partition method
 */
public class QuickSelect {

    public static Comparable select(Comparable[] a, int k) throws InvalidDataException {
        if (a.length < k) {
            throw new InvalidDataException("Array dos not contain enough items");
        }
        int low =  0;
        int high = a.length - 1;
//        int j = high + 1;
//        while (j > k) {
//            j = partition(a, low, --j);
//
//            if (j + 1 == k) {
//                return a[k];
//            }
//        }
        while (high > low) {
            int j = partition(a, low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = j - 1;
            }
            else {
                return a[k];
            }
        }
        return a[k];
    }


    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {

            while(a[++i].compareTo(a[low]) < 0) {
                if (i >= high) {
                    break;
                }
            }
            while (a[low].compareTo(a[--j]) < 0) {
                if (j <= low) {
                    break;
                }
            }
            // if j is smallest, do not exchange
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, low, j);
        return j;
    }

    private static void exchange(Comparable[] unsorted, int i, int j) {
        Comparable reserved = unsorted[i];
        unsorted[i] = unsorted[j];
        unsorted[j] = reserved;
    }
}
