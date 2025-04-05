package ca.mcmaster.se2aa4.mazerunner;

public class PathFinderFactory {
    public static PathFinder create(String algorithm) {
        if ("right-hand".equalsIgnoreCase(algorithm)) {
            return new RightHandRule();
        }
    
        throw new IllegalArgumentException("Unsupported algorithm: " + algorithm);
    }
    
}
