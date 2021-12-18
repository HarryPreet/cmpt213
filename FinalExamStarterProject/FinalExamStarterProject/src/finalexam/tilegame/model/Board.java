package finalexam.tilegame.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a board of tiles
 */
public class Board {
    private int numRows;
    private int numCols;
    private List<Tile> tiles = new ArrayList<>();
    private int score;

    public Board(char[][] map) {
        numRows = map.length;
        assert numRows > 0;
        numCols = map[0].length;

        initializeBoardTiles(map);
    }

    public int getNumRows() {
        return numRows;
    }
    public int getNumCols() {
        return numCols;
    }
    public int getScore() {
        return score;
    }

    public boolean isLocationInBoard(Location loc) {
        boolean isOkRow = loc.getRow() >= 0 && loc.getRow() < numRows;
        boolean isOkCol = loc.getCol() >= 0 && loc.getCol() < numCols;
        return isOkCol && isOkRow;
    }

    public void shovelTile(Location loc) {
        Tile tile = findTile(loc);
        tile.shovel();
        int points = tile.getScoreForShovelling(this);
        score += points;
    }

    public Tile findTile(Location loc) {
        for (Tile t : tiles) {
            if (t.isAt(loc)) {
                return t;
            }
        }
        assert false;
        return null;
    }


    private void initializeBoardTiles(char[][] map) {

        for (int row = 0; row < numRows; row++) {
            assert map[row].length == numCols;

            for (int col = 0; col < numCols; col++) {

                char tileType = map[row][col];
                Location loc = new Location(row, col);
                tiles.add(createTileByType(loc, tileType));

            }

        }
    }

    // Factory method: Create the tile based on the tile type.
    private Tile createTileByType(Location loc, char tileType) {
        switch (tileType) {
            case 'G':
                return new TileOfGrass(loc);

        }
        throw new IllegalArgumentException();
    }
}
