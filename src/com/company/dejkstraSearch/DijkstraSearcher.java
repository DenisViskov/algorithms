package com.company.dejkstraSearch;

import java.util.*;

public class DijkstraSearcher {

    /**
     * Run by graph -> updates costs of neighbors and put them to map
     * Find the lowest cost node amid of current neighbors
     * Put it to map by current node in for loop
     *
     * @param graph
     * @return path
     */
    public static Map<Nodes, Nodes> search(
        final Map<Nodes, Map<Nodes, Long>> graph
    ) {
        final var map = new HashMap<Nodes, Nodes>();
        final var costs = initCosts(graph);

        graph.forEach((it, neighbors) -> {
            neighbors.forEach((neighbor, cost) -> {
                final var newCost = costs.get(it) + cost;
                if (newCost < costs.get(neighbor)) {
                    costs.put(neighbor, newCost);
                    map.put(neighbor, it);
                }
            });
            final var lowestCostNode = findLowestCostNode(neighbors);
            map.put(lowestCostNode, it);
        });
        return resultParents(map);
    }

    /**
     * Build path from END to START node
     *
     * @param parents
     * @return path
     */
    private static Map<Nodes, Nodes> resultParents(final Map<Nodes, Nodes> parents) {
        final var result = new HashMap<Nodes, Nodes>();
        Nodes node = parents.get(Nodes.END);
        result.put(Nodes.END, node);
        while (node != null) {
            final var curr = node;
            node = parents.get(node);
            result.put(curr, node);
        }
        return result;
    }

    /**
     * Init costs where START node is 0 and others infinity
     *
     * @param graph
     * @return costs
     */
    private static Map<Nodes, Long> initCosts(
        final Map<Nodes, Map<Nodes, Long>> graph
    ) {
        final var costs = new HashMap<Nodes, Long>();
        costs.put(Nodes.START, 0L);
        graph.keySet().forEach(it -> {
            if (it != Nodes.START) {
                costs.put(it, Long.MAX_VALUE);
            }
        });
        return costs;
    }

    /**
     * Find the lowest cost node
     *
     * @param neighbors
     * @return Nodes
     */
    private static Nodes findLowestCostNode(
        final Map<Nodes, Long> neighbors
    ) {
        Nodes result = null;
        Long cost = null;
        for (final var entry : neighbors.entrySet()) {
            if (result == null) {
                result = entry.getKey();
            }
            if (cost == null) {
                cost = entry.getValue();
            }
            if (entry.getValue() < cost) {
                cost = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
