package io.enea.rockpaperorscissors.core.positions;

import io.enea.rockpaperorscissors.core.Judge;
import io.enea.rockpaperorscissors.core.PositionContract;

/**
 * Created by enea on 15/09/2017.
 */

abstract public class Position implements PositionContract {
    @Override
    public Boolean canWin(PositionContract rival) {
        return Judge.getInstance().getWinner(this, rival).getKey().equals(this.getKey());
    }
}
