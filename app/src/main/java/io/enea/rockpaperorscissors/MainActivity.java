package io.enea.rockpaperorscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.enea.rockpaperorscissors.core.PositionContract;
import io.enea.rockpaperorscissors.core.positions.Paper;
import io.enea.rockpaperorscissors.core.positions.Rock;
import io.enea.rockpaperorscissors.core.positions.Scissors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected HashMap<String, PositionContract> positions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// initialize the associative array
        this.positions = new HashMap<>();
        this.initialize();
    }

    protected void initialize() {
        this.buildAvailablePositions();
    }

    /**
     * Build all available positions.
     */
    protected void buildAvailablePositions() {
        this.availablePositions().forEach(x -> this.positions.put(x.getKey(), x));
    }

    /**
     * Returns all available positions in a generic list.
     *
     * @return the available positions
     */
    protected List<PositionContract> availablePositions() {
        return Arrays.asList(new Rock(), new Paper(), new Scissors());
    }
}
