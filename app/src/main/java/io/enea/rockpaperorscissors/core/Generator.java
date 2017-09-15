package io.enea.rockpaperorscissors.core;

import java.util.List;
import java.util.Random;

/**
 * Created by enea on 15/09/2017.
 */

public class Generator {

    protected Random random;
    protected List<PositionContract> positions;

    public Generator(Random random, List<PositionContract> positions) {
        this.random = random;
        this.positions = positions;
    }

    public PositionContract random() {
        int index = this.random.nextInt(this.positions.size());
        return this.positions.get(index);
    }
}
