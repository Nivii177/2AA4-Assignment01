class Explorer {
    private static final Logger logger = LogManager.getLogger(Explorer.class); 
    private final Maze maze;

    public Explorer(Maze maze) {
        this.maze = maze;
    }

    public void startExploration() {
        logger.info("Starting maze exploration...");
        // Placeholder for exploration logic.
        logger.info("Maze grid: " + maze.getGrid());
    }
}
