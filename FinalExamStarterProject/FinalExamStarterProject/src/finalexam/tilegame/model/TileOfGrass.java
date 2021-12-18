package finalexam.tilegame.model;

/**
 * Grass tile (simple)
 */
public class TileOfGrass extends Tile {
    public static final int POINTS_WHEN_SHOVELLED = 2;

    public TileOfGrass(Location location) {
        super(location);
    }

    @Override
    public int getScoreForShovelling(Board board) {
        return POINTS_WHEN_SHOVELLED;
    }
}
