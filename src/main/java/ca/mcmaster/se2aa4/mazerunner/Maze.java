package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Maze {
    private final List<String> grid = new ArrayList<>();

    public static Maze loadFromFile(String filePath) throws IOException {
        Maze maze = new Maze();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                maze.grid.add(line);
            }
        }
        return maze;
    }

    public List<String> getGrid() {
        return grid;
    }
}
