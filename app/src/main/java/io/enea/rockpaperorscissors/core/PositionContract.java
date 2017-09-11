package io.enea.rockpaperorscissors.core;

/**
 * Created by enea on 11/09/2017.
 */

public interface PositionContract {

    /**
     * Hand position identification.
     *
     * @return the key
     */
    String getKey();

    /**
     * Decides whether he can win or not.
     *
     * @return true if I win
     */
    Boolean canWin();
}
