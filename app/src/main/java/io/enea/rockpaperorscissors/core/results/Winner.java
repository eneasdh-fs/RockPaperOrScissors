package io.enea.rockpaperorscissors.core.results;

import io.enea.rockpaperorscissors.core.ResultContract;

/**
 * Created by enea on 15/09/2017.
 */

public class Winner implements ResultContract {
    @Override
    public String getMessage() {
        return "Ganaste :)";
    }

    @Override
    public String getIcon() {
        return "success";
    }

    @Override
    public String getTitle() {
        return "Mensaje";
    }
}
