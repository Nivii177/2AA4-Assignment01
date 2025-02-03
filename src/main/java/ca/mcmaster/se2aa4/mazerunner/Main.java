package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", "input", true, "Input maze file");
        options.addOption("algo", "algorithm", true, "Algorithm to use (default: right-hand rule)");

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("i")) {
                String inputFile = cmd.getOptionValue("i");
                Maze maze = new Maze(inputFile);

                PathFinder pathFinder = new RightHandRule(); // Default algorithm
                Explorer explorer = new Explorer(maze, pathFinder);

                String computedPath = explorer.computePath();
                logger.info("Computed Path: {}", computedPath);
            } else {
                logger.error("Missing required option: -i (input maze file)");
            }
        } catch (ParseException e) {
            logger.error("Error parsing command-line arguments: ", e);
        }

        logger.info("** End of Maze Runner");
    }
}
