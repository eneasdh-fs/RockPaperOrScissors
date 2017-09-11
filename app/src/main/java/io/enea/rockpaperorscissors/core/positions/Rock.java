package io.enea.rockpaperorscissors.core.positions;

import io.enea.rockpaperorscissors.core.PositionContract;

/**
 * Created by enea on 11/09/2017.
 */
public class Rock implements PositionContract {
    @Override
    public String getKey() {
        return "rock";
    }

    @Override
    public Boolean canWin() {
        return null;
    }
}
