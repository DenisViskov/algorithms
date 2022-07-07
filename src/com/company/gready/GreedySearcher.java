package com.company.gready;

import java.util.*;
import java.util.stream.Collectors;

public class GreedySearcher {

    public static Set<Radio> greedySearch(final Map<Radio, Set<States>> rangeOfCoveredAreas) {
        final var result = new HashSet<Radio>();
        final var statesNeeded = Arrays.stream(States.values()).collect(Collectors.toSet());
        while (!statesNeeded.isEmpty()) {

            final var statesCovered = new HashSet<States>();
            rangeOfCoveredAreas.forEach((radio, states) -> {
                    final var covered = new HashSet<>(statesNeeded);
                    covered.retainAll(states);
                    if (covered.size() > statesCovered.size()) {
                        result.add(radio);
                        statesCovered.addAll(covered);
                    }
                }
            );
            statesNeeded.removeAll(statesCovered);
        }
        return result;
    }
}
