package ca.mcmaster.se2aa4.mazerunner;

public class Explorer {
    private final PathFinder pathFinder;
    private final Maze maze;
    private int currentRow;
    private int currentCol;
    private char direction; 
   

    public Explorer(Maze maze) {
        this.maze = maze;
        this.currentRow = maze.getEntryRow();
        this.currentCol = maze.getEntryCol();
        this.direction = 'E';
    }

    public boolean verifyPath(String path) {
        for (char move : path.toCharArray()) {
            switch (move) {
                case 'F': 
                    if (!moveForward()) {
                        return false; 
                    }
                    break;
                case 'L': 
                    turnLeft();
                    break;
                case 'R': 
                    turnRight();
                    break;
                default:
                    return false; 
            }
        }
   
        return currentRow == maze.getExitRow() && currentCol == maze.getExitCol();
    }

    public String computePath() {
        return pathFinder.findPath(maze, maze.getEntryRow(), maze.getEntryCol(), 'E'); 
    }
    private boolean moveForward() {
        int newRow = currentRow;
        int newCol = currentCol;

        switch (direction) {
            case 'N': newRow--; break;
            case 'E': newCol++; break;
            case 'S': newRow++; break;
            case 'W': newCol--; break;
        }

        if (maze.isValidPosition(newRow, newCol)) {
            currentRow = newRow;
            currentCol = newCol;
            return true;
        }
        return false; // Hit a wall or out of bounds
    }

    private void turnLeft() {
        switch (direction) {
            case 'N': direction = 'W'; break;
            case 'E': direction = 'N'; break;
            case 'S': direction = 'E'; break;
            case 'W': direction = 'S'; break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N': direction = 'E'; break;
            case 'E': direction = 'S'; break;
            case 'S': direction = 'W'; break;
            case 'W': direction = 'N'; break;
        }
    }
}
