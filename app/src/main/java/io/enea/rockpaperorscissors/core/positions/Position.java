package io.enea.rockpaperorscissors.core.positions;

import io.enea.rockpaperorscissors.core.Judge;
import io.enea.rockpaperorscissors.core.PositionContract;
import io.enea.rockpaperorscissors.core.ResultContract;
import io.enea.rockpaperorscissors.core.results.Joint;
import io.enea.rockpaperorscissors.core.results.Loser;
import io.enea.rockpaperorscissors.core.results.Winner;

/**
 * Created by enea on 15/09/2017.
 */

abstract public class Position implements PositionContract {
    @Override
    public ResultContract canWin(PositionContract rival) {
        return this.getResult(rival);
    }

    @Override
    public String getKey() {
        return this.getClass().getName();
    }

    protected ResultContract getResult(PositionContract rival) {
        if (this.isSameKeys(rival)) {
            return new Joint();
        }

        if (!this.isSameKeys(Judge.getInstance().getWinner(this, rival))) {
            return new Loser();
        }

        return new Winner();
    }

    protected Boolean isSameKeys(PositionContract position) {
        return position.getKey().equals(this.getKey());
    }
}
