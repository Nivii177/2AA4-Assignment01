package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule implements PathFinder{

    public String findPath(Maze maze, int startRow, int startCol, char startDirection){
        int row = startRow;
        int col = startCol;
        char direction = startDirection;
        StringBuilder path = new StringBuilder();

        while (!(row == maze.getExitRow() && col == maze.getExitCol())){
            if (canMoveRight(maze, row, col, direction)){
                direction  = turnRight(direction);
                path.append('R');
            }

            if (canMoveForward(maze, row, col, direction)){
                row = getNextRow(row, direction);
                col = getNextCol(col, direction);
                path.append('F');
            }else{
                direction = turnLeft(direction);
                path.append('L');
            }
        }
        return factorizePath(path.toString());
    }

    private boolean canMoveForward(Maze maze, int row, int col, char direction){
        int newRow = getNextRow(row, direction);
        int newCol = getNextCol(col, direction);
        return maze.isValidPosition(newRow, newCol);
    }

    private boolean canMoveRight(Maze maze, int row, int col, char direction){
        char rightDirection  = turnRight(direction);
        int newRow = getNextRow(row, rightDirection);
        int newCol = getNextCol(col, rightDirection);
        return maze.isValidPosition(newRow, newCol);
    }

    private int getNextRow(int row, int direction){
        return direction == 'N' ? row-1 : direction == 'S' ? row + 1 : row;
    }

    private int getNextCol( int col, int direction){
        return direction == 'E' ? col + 1 : direction == 'W' ? col - 1 : col;
    }

    private char turnLeft(char direction) {
        switch (direction) {
            case 'N': return 'W';
            case 'W': return 'S';
            case 'S': return 'E';
            case 'E': return 'N';
            default: return direction;
        }
    }

    private char turnRight(char direction) {
        switch (direction) {
            case 'N': return 'E';
            case 'E': return 'S';
            case 'S': return 'W';
            case 'W': return 'N';
            default: return direction;
        }
    }

    private String factorizePath(String path) {
        StringBuilder result = new StringBuilder();
        char prev = path.charAt(0);
        int count = 1;

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == prev) {
                count++;
            } else {
                if (count > 1) {
                    result.append(count);
                }
                result.append(prev);
                prev = path.charAt(i);
                count = 1;
            }
        }

        if (count > 1) {
            result.append(count);
        }
        result.append(prev);
        return result.toString();
    }

}
