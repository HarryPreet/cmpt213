package finalexam.tilegame.ui;

import finalexam.tilegame.model.Board;
import finalexam.tilegame.model.Location;

/**
 * Test the Tile shovelling game
 */
public class Main {
    public static void main(String[] arg) {
        testSmallGrassGame();
        testPathTiles();
    }

    private static void testSmallGrassGame() {
        System.out.println("\nDoing small grass game:");
        char[][] map = {
                {'G', 'G'},
                {'G', 'G'},
        };
        Board board = new Board(map);

        // Shovel some tiles
        board.shovelTile(new Location(0, 0));
        board.shovelTile(new Location(1, 0));
        board.shovelTile(new Location(1, 1));

        System.out.println("Score: " + board.getScore());
    }


    private static void testPathTiles() {
        System.out.println("\nDoing game with path tiles:");
        System.out.println("NOTE: This test will crash until you implement the path tile code!");

        char[][] map = {
                {'P', 'P', 'P', 'P', 'P', 'P'},
        };
        Board board = new Board(map);

        // Shovel some locations
        board.shovelTile(new Location(0, 1));
        int changeInScore = 0;

        changeInScore = scoreForShovellingNewLocation(board, new Location(0, 3));
        System.out.println("Change in score: " + changeInScore);

        changeInScore = scoreForShovellingNewLocation(board, new Location(0, 4));
        System.out.println("Change in score: " + changeInScore);

        changeInScore = scoreForShovellingNewLocation(board, new Location(0, 5));
        System.out.println("Change in score: " + changeInScore);

        changeInScore = scoreForShovellingNewLocation(board, new Location(0, 0));
        System.out.println("Change in score: " + changeInScore);

        changeInScore = scoreForShovellingNewLocation(board, new Location(0, 2));
        System.out.println("Change in score: " + changeInScore);

        System.out.println("Total score: " + board.getScore());
    }

    private static int scoreForShovellingNewLocation(Board board, Location location) {
        int initialScore = board.getScore();
        board.shovelTile(location);
        return board.getScore() - initialScore;
    }
}
