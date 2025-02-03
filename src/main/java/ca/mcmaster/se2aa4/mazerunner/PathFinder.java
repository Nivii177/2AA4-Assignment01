package ca.mcmaster.se2aa4.mazerunner;

public interface PathFinder {
  String findPath(Maze maze, int startRow, int startCol, char startDirection);
}