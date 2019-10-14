package com.quicksort;

import com.sun.media.sound.InvalidDataException;
import org.junit.jupiter.api.Test;

public class QuickSelectTest {

    @Test
    public void testQuickSelect() {

        Comparable[] a = new Comparable[] {3, 2, 1};
        int k = 2; // look for the second smallest item which is 2
        try {
            QuickSelect.select(a, k);
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }

    }
}
