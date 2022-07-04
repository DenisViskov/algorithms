package com.company.dejkstraSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearcher {

    private static final Set<Nodes> PROCESSED = new HashSet<>();

    public static Map<Nodes, Nodes> search(
        final Map<Nodes, Map<Nodes, Long>> graph,
        final Map<Nodes, Long> costs
    ) {
        var parents = new HashMap<Nodes, Nodes>();

        var node = findLowestCostNode(costs);
        while (node != null) {
            final var cost = costs.get(node);

            final var neighbors = graph.get(node);
            for (final var n : neighbors.keySet()) {
                final var newCost = cost + neighbors.get(n);
                if (costs.get(n) > newCost) {
                    costs.put(n, newCost);
                    parents.put(n, node);
                }
            }
            PROCESSED.add(node);
            node = findLowestCostNode(costs);
        }
        return parents;
    }

    private static Nodes findLowestCostNode(final Map<Nodes, Long> costs) {
        var lowestCost = Long.MAX_VALUE;

        Nodes lowestCostNode = null;
        for (final var node : costs.keySet()) {
            final var cost = costs.get(node);
            if (cost < lowestCost && !PROCESSED.contains(node)) {
                lowestCost = cost;
                lowestCostNode = node;
            }
        }
        return lowestCostNode;
    }
}
