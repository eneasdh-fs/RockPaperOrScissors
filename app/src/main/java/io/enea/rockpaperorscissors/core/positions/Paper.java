package io.enea.rockpaperorscissors.core.positions;

import io.enea.rockpaperorscissors.core.PositionContract;

/**
 * Created by enea on 11/09/2017.
 */

public class Paper implements PositionContract {
    @Override
    public String getKey() {
        return "paper";
    }

    @Override
    public String getImagePath() {
        return "paper";
    }

    @Override
    public Boolean canWin() {
        return null;
    }

}
