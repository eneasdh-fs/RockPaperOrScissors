package io.enea.rockpaperorscissors.core;

import io.enea.rockpaperorscissors.core.positions.Paper;
import io.enea.rockpaperorscissors.core.positions.Rock;
import io.enea.rockpaperorscissors.core.positions.Scissors;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by enea on 11/09/2017.
 */

public class Judge {

    protected static Judge instance = new Judge();
    protected static HashMap<String, List<String>> relations = new HashMap();

    private Judge() {
    }

    public static Judge getInstance() {
        if (relations.size() == 0) {
            loadRules();
        }

        return instance;
    }

    public PositionContract getWinner(PositionContract payer, PositionContract rival) {
        return relations.get(payer.getKey()).contains(rival.getKey()) ? payer : rival;
    }

    protected static void loadRules() {
        relations.put(Paper.class.getName(), Collections.singletonList(Rock.class.getName()));
        relations.put(Rock.class.getName(), Collections.singletonList(Scissors.class.getName()));
        relations.put(Scissors.class.getName(), Collections.singletonList(Paper.class.getName()));
    }
}
