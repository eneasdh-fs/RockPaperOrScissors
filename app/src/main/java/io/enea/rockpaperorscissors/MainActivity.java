package io.enea.rockpaperorscissors;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import io.enea.rockpaperorscissors.core.Generator;
import io.enea.rockpaperorscissors.core.PositionContract;
import io.enea.rockpaperorscissors.core.positions.Paper;
import io.enea.rockpaperorscissors.core.positions.Rock;
import io.enea.rockpaperorscissors.core.positions.Scissors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected HashMap<String, PositionContract> positions;
    protected PositionContract selectedPosition;
    protected LinearLayout wrapper;
    protected Button game;
    protected ImageView user;
    protected ImageView rival;
    protected Generator generator;
    protected final String DEFAULT_IMAGE = "unknown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// initialize the associative array
        this.positions = new HashMap<>();
        this.initialize();
    }


    /**
     * Initialize all components and attach the events.
     */
    protected void initialize() {
        this.wrapper = (LinearLayout) findViewById(R.id.wrapper_positions);
        this.user = (ImageView) findViewById(R.id.user);
        this.rival = (ImageView) findViewById(R.id.rival);
        this.generator = new Generator(new Random(), this.availablePositions());
        this.game = (Button) findViewById(R.id.game);
        Button restart = (Button) findViewById(R.id.restart);

        this.game.setOnClickListener(view -> this.playNow());
        restart.setOnClickListener(view -> this.restart());

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

    /**
     * Returns all items to their default values.
     */
    protected void restart() {
        this.selectedPosition = null;
        this.game.setEnabled(true);
        this.user.setImageResource(this.getDrawableResourceKey(DEFAULT_IMAGE));
        this.rival.setImageResource(this.getDrawableResourceKey(DEFAULT_IMAGE));
    }

    /**
     * The game starts.
     */
    protected void playNow() {
        if (!this.isValidSelection()) {
            this.makeMessage("Incompleto", "Asegurese que escoger un elemento :)", R.drawable.error);
            return;
        }

        this.game.setEnabled(false);
        PositionContract position = this.generator.random();
        this.rival.setImageResource(this.extractImage(position));

        Boolean win = this.selectedPosition.canWin(position);

        int status = win ? R.drawable.success : R.drawable.error;
        String message = win ? "Ganaste" : "Perdiste :v";

        this.makeMessage("Mensaje", message, status);
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
     * @return true if the selection is valid
     */
    protected Boolean isValidSelection() {
        return this.selectedPosition != null;
    }

    /**
     * Show an custom message,
     *
     * @param title
     * @param message
     */
    protected void makeMessage(String title, String message, int status) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(message).setIcon(status).show();
    }

    /**
     * Extracts the name of the image from the position and returns its identification.
     *
     * @param position
     * @return the image id
     */
    protected int extractImage(PositionContract position) {
        return this.getDrawableResourceKey(position.getImagePath());
    }

    /**
     * Returns the Drawable resource ID.
     *
     * @param name
     * @return the resource id
     */
    private int getDrawableResourceKey(String name) {
        return getResources().getIdentifier(name, "drawable", getPackageName());
    }
}
