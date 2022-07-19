package com.company.dynamicProgramming;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AttractionSolution {

    private static final Map<Double, Integer> CELLS_BY_DAYS = Map.of(
            0.5, 0,
            1.0, 1,
            1.5, 2,
            2.0, 3
    );

    private static final Map<Integer, Double> DAYS_BY_CELLS = Map.of(
            0, 0.5,
            1, 1.0,
            2, 1.5,
            3, 2.0
    );

    /**
     * 1. Go by attractions
     * 2. Compare can we allocate attraction in current restriction (by days)
     *    If yes ->
     *      check that remains a place -> summarize maximum from remained place on previous step
     *                                    with current attraction and then compare the same position
     *                                    on upper level (select most)
     *
     *      don't have any more place -> compare the same place on upper level (select most)
     *
     *    if not -> pick maximum from previous step for current position
     * @param attractions
     * @return
     */
    public static int[][] selectedAttractions(final List<Attraction> attractions) {
        final var table = new int[attractions.size()][CELLS_BY_DAYS.size()];

        for (int attrIndex = 0; attrIndex < table.length; attrIndex++) {
            final var attraction = attractions.get(attrIndex);
            for (int daysIndex = 0; daysIndex < table[attrIndex].length; daysIndex++) {
                if (attrIndex > 0) {
                    setWhenHasPreviousAttraction(attraction, table, attrIndex, daysIndex);
                } else {
                    setWhenPreviousAttractionAbsent(attraction, table, attrIndex, daysIndex);
                }
            }
        }

        return table;
    }

    private static void setWhenPreviousAttractionAbsent(
            final Attraction attraction,
            final int[][] table,
            final int attrIndex,
            final int daysIndex
    ) {
        if (attraction.getTimeInDays() <= DAYS_BY_CELLS.get(daysIndex)) {
            table[attrIndex][daysIndex] = attraction.getGrade();
        } else {
            table[attrIndex][daysIndex] = 0;
        }
    }

    private static void setWhenHasPreviousAttraction(
            final Attraction attraction,
            final int[][] table,
            final int attrIndex,
            final int daysIndex
    ) {
        if (attraction.getTimeInDays() < DAYS_BY_CELLS.get(daysIndex)) {
            final var remainsFree = DAYS_BY_CELLS.get(daysIndex) - attraction.getTimeInDays();
            final var summWithPrevMax = table[attrIndex - 1][CELLS_BY_DAYS.get(remainsFree)] + attraction.getGrade();
            table[attrIndex][daysIndex] = Math.max(summWithPrevMax, table[attrIndex - 1][daysIndex]);
        } else if (Objects.equals(attraction.getTimeInDays(), DAYS_BY_CELLS.get(daysIndex))) {
            table[attrIndex][daysIndex] = Math.max(attraction.getGrade(), table[attrIndex - 1][daysIndex]);
        } else {
            table[attrIndex][daysIndex] = table[attrIndex - 1][daysIndex];
        }
    }
}
