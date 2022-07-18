package com.company.dynamicProgramming;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AttractionSolution {

    private final Map<Double, Integer> cellsByDays = Map.of(
            0.5, 0,
            1.0, 1,
            1.5, 2,
            2.0, 3
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
    public static List<Attraction> selectedAttractions(final List<Attraction> attractions) {
        final var table = new int[attractions.size()][4];

        return Collections.emptyList();
    }
}
