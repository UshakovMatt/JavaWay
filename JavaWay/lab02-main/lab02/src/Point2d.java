public class Point2d {

    private double x;

    private double y;

    public Point2d ( double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2d () {
//Вызовите конструктор с двумя параметрами и определите источник.
        this(0, 0);
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public void setX ( double val) {
        x = val;
    }

    public void setY ( double val) {
        y = val;
    }

}
