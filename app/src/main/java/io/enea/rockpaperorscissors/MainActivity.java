package io.enea.rockpaperorscissors;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import io.enea.rockpaperorscissors.core.PositionContract;
import io.enea.rockpaperorscissors.core.positions.Paper;
import io.enea.rockpaperorscissors.core.positions.Rock;
import io.enea.rockpaperorscissors.core.positions.Scissors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected HashMap<String, PositionContract> positions;
    protected PositionContract selectedPosition;
    protected LinearLayout wrapper;
    protected ImageView user;
    protected ImageView rival;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// initialize the associative array
        this.positions = new HashMap<>();
        this.initialize();
    }


    protected void initialize() {
        this.wrapper = (LinearLayout) findViewById(R.id.wrapper_positions);
        this.user = (ImageView) findViewById(R.id.user);
        this.rival = (ImageView) findViewById(R.id.rival);

        this.restart();
        this.buildAvailablePositions();
    }

    /**
     * Build all available positions.
     */
    protected void buildAvailablePositions() {
        for (PositionContract shape : this.availablePositions()) {
            this.positions.put(shape.getKey(), shape);

            /// Build the positions.
            ImageView image = this.makeImage(shape);

            /// Listing the Click event.
            image.setOnClickListener(view -> {
                PositionContract position = this.positions.get(shape.getKey());
                this.choose(position);
            });

            /// Add to container.
            this.wrapper.addView(image);
        }
    }

    /**
     * Builds an image for position.
     *
     * @return the built image
     */
    protected ImageView makeImage(PositionContract position) {
        /// Create image view
        ImageView image = new ImageView(this);

        /// Set the image.
        int path = this.extractImage(position);
        image.setImageResource(path);

        /// Set size
        image.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return image;
    }

    /**
     * Set the position selected by the user.
     *
     * @param position
     */
    protected void choose(PositionContract position) {
        this.selectedPosition = position;
        this.user.setImageResource(this.extractImage(position));
    }

    protected void restart() {
        this.selectedPosition = null;
    }

    /**
     * Returns all available positions in a generic list.
     *
     * @return the available positions
     */
    protected List<PositionContract> availablePositions() {
        return Arrays.asList(new Rock(), new Paper(), new Scissors());
    }

    /**
     * Extracts the name of the image from the position and returns its identification.
     *
     * @param position
     * @return the image id
     */
    protected int extractImage(PositionContract position) {
        return getResources().getIdentifier(position.getImagePath(), "drawable", getPackageName());
    }

}
