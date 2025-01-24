package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.parser.ParseException;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // Configure Apache CLI
        Options options = new Options();
        
        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            logger.error("Failed to parse command line arguments", e);
            formatter.printHelp("MazeRunner", options);
            return;
        }

        String inputFilePath = cmd.getOptionValue("input");
        logger.info("Input file path: " + inputFilePath);

        Maze maze;
        try {
            maze = Maze.loadFromFile(inputFilePath);
            logger.info("Maze loaded successfully.");
        } catch (IOException e) {
            logger.error("Error reading the maze file", e);
            return;
        }

        Explorer explorer = new Explorer(maze);
        explorer.startExploration();

        logger.info("Maze exploration complete.");
    }
}

