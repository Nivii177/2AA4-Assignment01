// === ExplorerTest.java ===
package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExplorerTest {
    private Maze maze;
    private Explorer explorer;

    @BeforeEach
    public void setUp() {
        maze = new Maze("./examples/small.maz.txt");
        explorer = new Explorer(maze, new RightHandRule());
    }

    @Test
    public void testVerifyValidPath() {
        assertTrue(explorer.verifyPath("FFFFFRFFFF"));
    }

    @Test
    public void testVerifyInvalidPathBlocked() {
        assertFalse(explorer.verifyPath("FFFFLFFFF"));
    }

    @Test
    public void testVerifyEmptyPath() {
        assertFalse(explorer.verifyPath(""));
    }

    @Test
    public void testComputePathEndsAtExit() {
        String path = explorer.computePath();
        assertTrue(explorer.verifyPath(path));
    }

    @Test
    public void testComputePathNotEmpty() {
        String path = explorer.computePath();
        assertNotNull(path);
        assertFalse(path.isEmpty());
    }
    @Test
    public void testRightHandRuleProducesPath() {
        RightHandRule rule = new RightHandRule();
        String path = rule.findPath(maze, maze.getEntryRow(), maze.getEntryCol(), 'E');
        assertNotNull(path);
        assertFalse(path.isEmpty());
    }

    @Test
    public void testRightHandRulePathValidity() {
        RightHandRule rule = new RightHandRule();
        String path = rule.findPath(maze, maze.getEntryRow(), maze.getEntryCol(), 'E');
        assertTrue(explorer.verifyPath(path));
    }

    @Test
    public void testRightHandRulePathStartsCorrectly() {
        RightHandRule rule = new RightHandRule();
        String path = rule.findPath(maze, maze.getEntryRow(), maze.getEntryCol(), 'E');
        assertTrue(path.charAt(0) == 'F' || path.charAt(0) == 'R' || path.charAt(0) == 'L');
    }

    @Test
    public void testMazeValidPosition() {
        assertTrue(maze.isValidPosition(maze.getEntryRow(), maze.getEntryCol()));
    }

    @Test
    public void testMazeGetTile() {
        char tile = maze.getTile(maze.getEntryRow(), maze.getEntryCol());
        assertEquals(' ', tile);
    }
}
