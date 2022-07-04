package com.company;

import com.company.dejkstraSearch.DijkstraSearcher;
import com.company.dejkstraSearch.DejkstraGraphStub;

public class Main {

    public static void main(String[] args) {
        DijkstraSearcher.search(
            DejkstraGraphStub.getGraph2(),
            DejkstraGraphStub.getCosts2()
        );
    }
}
