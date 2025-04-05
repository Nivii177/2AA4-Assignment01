package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", "input", true, "Input maze file");
        options.addOption("algo", "algorithm", true, "Algorithm to use (default: right-hand rule)");
        options.addOption("p", "path", true, "Path to verify");

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("i")) {
                String inputFile = cmd.getOptionValue("i");
                Maze maze = Maze.getInstance(inputFile);

                // Use Factory to create PathFinder
                String algorithm = cmd.getOptionValue("algo", "right-hand");
                PathFinder pathFinder = PathFinderFactory.create(algorithm); // Factory call

                Explorer explorer = new Explorer(maze, pathFinder);

                if (cmd.hasOption("p")) {
                    String path = cmd.getOptionValue("p");
                    boolean isValid = explorer.verifyPath(path);
                    logger.info("Path verification result: {}", isValid ? "Valid" : "Invalid");
                } else {
                    String computedPath = explorer.computePath();
                    logger.info("Computed Path: {}", computedPath);
                }
            } else {
                logger.error("Missing required option: -i (input maze file)");
            }
        } catch (ParseException e) {
            logger.error("Error parsing command-line arguments: ", e);
        }

        logger.info("** End of Maze Runner");
    }
}