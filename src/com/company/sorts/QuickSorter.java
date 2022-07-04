package com.company.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class QuickSorter {

    public static int[] quickSort(final int[] array) {
        if (array.length < 2) {
            return array;
        }

        final var pivot = array.length / 2;
        final var less = separateBy(array, array[pivot], (el, val) -> el < val);
        final var greater = separateBy(array, array[pivot], (el, val) -> el > val);

        return collect(quickSort(less), array[pivot], quickSort(greater));
    }

    private static int[] separateBy(
        final int[] array,
        final int pivot,
        final BiPredicate<Integer, Integer> condition
    ) {
        final var result = new ArrayList<Integer>();
        for (int el : array) {
            if (condition.test(el, pivot)) {
                result.add(el);
            }
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private static int[] collect(final int[] less, final int pivot, final int[] greater) {
        final var result = new ArrayList<Integer>();
        Arrays.stream(less).forEach(result::add);
        result.add(pivot);
        Arrays.stream(greater).forEach(result::add);
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
