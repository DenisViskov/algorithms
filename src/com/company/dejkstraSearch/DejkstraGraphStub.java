package com.company.dejkstraSearch;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.company.dejkstraSearch.Nodes.*;

public class DejkstraGraphStub {

    public static Map<Nodes, Long> getCosts() {
        final var map = new HashMap<Nodes, Long>();
        map.put(A, 5L);
        map.put(B, 0L);
        map.put(C, 30L);
        map.put(D, 35L);
        map.put(END, Long.MAX_VALUE);
        return map;
    }

    public static Map<Nodes, Map<Nodes, Long>> getGraph() {
        final var map = new LinkedHashMap<Nodes, Map<Nodes, Long>>();
        map.put(START, Map.of(A, 5L, B, 0L));
        map.put(A, Map.of(C, 15L, D, 20L));
        map.put(B, Map.of(C, 30L, D, 35L));
        map.put(C, Map.of(END, 20L));
        map.put(D, Map.of(END, 10L));
        map.put(END, Collections.emptyMap());
        return map;
    }
}
