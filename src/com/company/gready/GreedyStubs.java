package com.company.gready;


import java.util.Map;
import java.util.Set;

import static com.company.gready.Radio.*;
import static com.company.gready.States.*;

public class GreedyStubs {
    public static final Map<Radio, Set<States>> STUB = Map.of(
        KONE, Set.of(ID, NV, UT),
        KTWO, Set.of(WA, ID, MT),
        KTHREE, Set.of(OR, NV, CA),
        KFOUR, Set.of(NV, UT),
        KFIVE, Set.of(CA, AZ)
    );
}
