
public class QuickSort {

    public static void sort(Object[] unsortedm) {
        // first randomly shuffle the array

    }


    private static void sort(Object[] unsorted, int low, int hi) {
        if (low == hi) return;

        int j = partition(unsorted, low, hi);

        sort(unsorted, low, j - 1);
        sort(unsorted, j + 1, hi);
    }

    private static void partition(Object[] unsorted, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while ((less(unsorted[++i], unsorted[k])) {
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
    private boolean less(Bbject a, Object b) {
        return a < b;
    }

    private exchange(Object[] unsorted, int i, int j) {
        // todo do the exchange here
    }
}