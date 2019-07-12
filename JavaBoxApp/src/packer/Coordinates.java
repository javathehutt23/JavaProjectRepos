package packer;

/**
 *
 * @author Harry Furnish
 * @version 1.0
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    /**
     * Coordinates used by both customer and depot and used to caclulatee distances and closest info for dispatch
     * @param x double x coordinate
     * @param y double y coordinate
     */
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * getX provide x coordinate
     * @return double x coordinate
     */
    public double getX() {
        return x;
    }
    /**
     * getY provides y coordinate
     * @return double y coordinate
     */
    public double getY() {
        return y;
    }
    /**
     * euclidianDistanceTo provides distance between two sets of coordinates
     * @param other coordinates other 
     * @return double calculated distance
     */
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    /**
     * manhattanDistanceTo provides distance between two sets of coordinates
     * @param other coordinates other
     * @return double calculated distance
     */
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    /**
    * Calculates the distances between two coordinates given
     * @param other coordinates other
     * @return double calculated distance
    **/
    public double companyDistanceTo(Coordinates other) {
        double xDiff1 = other.getX() - this.getX();
        double yDiff1 = other.getY() - this.getY();
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1),0.5);
        double xDiff2 = other.getX() - this.getX();
        double yDiff2 = other.getY() - this.getY();
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return (dist1 + dist2)/2 + 1;
    }

}
