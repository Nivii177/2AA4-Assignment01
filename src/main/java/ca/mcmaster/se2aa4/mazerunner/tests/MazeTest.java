package ca.mcmaster.se2aa4.mazerunner.tests;

import ca.mcmaster.se2aa4.mazerunner.Maze;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MazeTest {

    public void testParseMaze(){
        Maze maze = new Maze ("test_maze.txt");
        assertEquals(10, maze.getHeight());
        assertEquals(10, maze.getWidth());
    }

    
}
