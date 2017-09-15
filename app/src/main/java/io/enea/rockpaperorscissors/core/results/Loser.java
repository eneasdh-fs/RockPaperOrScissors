package io.enea.rockpaperorscissors.core.results;

import io.enea.rockpaperorscissors.core.ResultContract;

/**
 * Created by enea on 15/09/2017.
 */

public class Loser implements ResultContract {
    @Override
    public String getMessage() {
        return "Perdiste :V";
    }

    @Override
    public String getIcon() {
        return "error";
    }

    @Override
    public String getTitle() {
        return "Mensaje";
    }
}
