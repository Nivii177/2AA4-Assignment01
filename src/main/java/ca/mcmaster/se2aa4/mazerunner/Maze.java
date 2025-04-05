package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private static Maze instance;

    private char[][] grid;
    private int entryRow, entryCol;
    private int exitRow, exitCol;

    private Maze(String filePath) {
        parseMaze(filePath);
        findEntryAndExit();
    }

    public static Maze getInstance(String filePath) {
        if (instance == null) {
            instance = new Maze(filePath);
        }
        return instance;
    }

    private void parseMaze(String filePath) {
        List<char[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rows.add(line.toCharArray());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read maze file: " + filePath, e);
        }
        grid = rows.toArray(new char[0][]);
    }

    private void findEntryAndExit() {
        for (int row = 0; row < grid.length; row++) {
            if (grid[row][0] == ' ') {
                entryRow = row;
                entryCol = 0;
                break;
            }
        }

        for (int row = 0; row < grid.length; row++) {
            if (grid[row][grid[row].length - 1] == ' ') {
                exitRow = row;
                exitCol = grid[row].length - 1;
                break;
            }
        }
    }

    public char getTile(int row, int col) {
        return grid[row][col];
    }

    public int getHeight() {
        return grid.length;
    }

    public int getWidth() {
        return grid[0].length;
    }

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < getHeight() && col >= 0 && col < getWidth() && grid[row][col] == ' ';
    }

    public int getEntryRow() {
        return entryRow;
    }

    public int getEntryCol() {
        return entryCol;
    }

    public int getExitRow() {
        return exitRow;
    }

    public int getExitCol() {
        return exitCol;
    }

}
