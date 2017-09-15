package io.enea.rockpaperorscissors.core.positions;

/**
 * Created by enea on 11/09/2017.
 */
public class Rock extends Position {
    @Override
    public String getKey() {
        return "rock";
    }

    @Override
    public String getImagePath() {
        return "rock";
    }
}
