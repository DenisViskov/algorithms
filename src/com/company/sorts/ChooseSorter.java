package com.company.sorts;

public class ChooseSorter {

    public static int[] sort(final int[] array) {
        for (int i = 0; i < array.length; i++) {

            var max = array[i];
            for (int j = 0; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    array[j] = array[i];
                    array[i] = max;
                }
            }
        }

        return array;
    }
}
