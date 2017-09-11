package io.enea.rockpaperorscissors.core;

import java.util.HashMap;
import java.util.List;

/**
 * Created by enea on 11/09/2017.
 */

public class Repository {

    protected HashMap<String, String> positions;

    public Repository() {
        this.positions = new HashMap<>();
    }


    /**
     * Registers positions and their weaknesses.
     *
     * @param position
     * @param weakness
     * @return the repository
     */
    protected Repository register(PositionContract position, PositionContract weakness) {
        this.positions.put(position.getClass().getName(), weakness.getClass().getName());
        return this;
    }
}
