package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



class Explorer {
    private static final Logger logger = LogManager.getLogger(Explorer.class);
    private final Maze maze;

    public Explorer(Maze maze) {
        this.maze = maze;
    }

    public void startExploration() {
        logger.info("Starting maze exploration...");
        int[] entry = maze.getEntryPoint();
        int[] exit = maze.getExitPoint();
        logger.info("Entry point: (" + entry[0] + ", " + entry[1] + ")");
        logger.info("Exit point: (" + exit[0] + ", " + exit[1] + ")");
        // Placeholder for exploration logic.
    }
}
