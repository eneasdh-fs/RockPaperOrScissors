package io.enea.rockpaperorscissors.core;

/**
 * Created by enea on 11/09/2017.
 */

public class Judge {

    protected static Judge instance = new Judge();

    private Judge() {
    }

    public static Judge getInstance() {
        return instance;
    }


    public PositionContract getWinner(PositionContract payer, PositionContract rival) {
        return null;
    }
}
