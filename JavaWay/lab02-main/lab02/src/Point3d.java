public class Point3d extends Point2d {
    private double z;
    public Point3d (double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    public Point3d() {
        this(0, 0, 0);
    }
    public double distanceTo(Point3d otherPoint3d){
        return Math.sqrt(
                (otherPoint3d.getX() - getX()) * (otherPoint3d.getX() - getX())
                        + (otherPoint3d.getY() - getY()) * (otherPoint3d.getY() - getY())
                        + (otherPoint3d.getZ() - getZ()) * (otherPoint3d.getZ() - getZ()));
    }
    public double getZ(){
        return z;
    }
    public void setZ(double val){
        z = val;
    }
}
