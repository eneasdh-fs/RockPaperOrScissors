package io.enea.rockpaperorscissors.core.positions;

/**
 * Created by enea on 11/09/2017.
 */

public class Paper extends Position {
    @Override
    public String getKey() {
        return "paper";
    }

    @Override
    public String getImagePath() {
        return "paper";
    }
}
