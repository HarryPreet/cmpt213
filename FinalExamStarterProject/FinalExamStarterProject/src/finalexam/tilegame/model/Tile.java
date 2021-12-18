package finalexam.tilegame.model;

/**
 * Base class for tiles to be shovelled.
 */
abstract public class Tile {
    private Location loc;
    private boolean isShovelled;

    public Tile(Location location) {
        this.loc = location;
    }

    public Location getLocation() {
        return loc;
    }
    public boolean isAt(Location loc) {
        return loc.equals(this.loc);
    }

    public boolean isShovelled() {
        return isShovelled;
    }
    public void shovel() {
        isShovelled = true;
    }

    public abstract int getScoreForShovelling(Board board);
}
