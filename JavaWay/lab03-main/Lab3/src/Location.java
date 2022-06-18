/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/

public class Location {
    /**
     * X coordinate of this location.
     **/
    public int xCoord;

    /**
     * Y coordinate of this location.
     **/
    public int yCoord;

    /**
     * Creates a new location with the specified integer coordinates.
     **/
    public Location(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    /**
     * Creates a new location with coordinates (0, 0).
     **/
    public Location() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof Location) {
            Location other = (Location) obj;
            return other.xCoord == xCoord && other.yCoord == yCoord;
        } else return false;
    }

    @Override
    public int hashCode() {
        return 31 * Integer.hashCode(xCoord) + Integer.hashCode(yCoord);
    }
}