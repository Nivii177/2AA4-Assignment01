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
        options.addOption("p", "path", true, "Path to verify");

        try {
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("i")) {
                String inputFile = cmd.getOptionValue("i");
                Maze maze = new Maze(inputFile);

                if (cmd.hasOption("p")) {
                    String path = cmd.getOptionValue("p");
                    Explorer explorer = new Explorer(maze);
                    boolean isValid = explorer.verifyPath(path);
                    logger.info("Path verification result: {}", isValid ? "Valid" : "Invalid");
                } else {
                    logger.error("Missing required option: -p (path to verify)");
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
