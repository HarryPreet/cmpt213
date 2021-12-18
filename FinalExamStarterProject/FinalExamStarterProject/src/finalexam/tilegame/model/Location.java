package finalexam.tilegame.model;

import java.util.Objects;

/**
 *  Immutable class to store a location, and find near-by locations.
 */
public class Location {
    private int row;
    private int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }

    // Useful methods to get a new location in a direction
    public Location toRight() {
        return new Location(row, col + 1);
    }
    public Location toLeft() {
        return new Location(row, col - 1);
    }
    public Location toTop() {
        return new Location(row - 1, col);
    }
    public Location toBottom() {
        return new Location(row + 1, col);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location loc = (Location) o;
        return row == loc.row &&
                col == loc.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

}
