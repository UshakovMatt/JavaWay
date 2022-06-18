import java.awt.geom.Rectangle2D;

public class Tricorn extends FractalGenerator {
    private static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2;
        range.width = 4;
        range.height = 4;
    }

    @Override
    public int numIterations(double x0, double y0) {
        int iter = 0;
        double x = 0;
        double y = 0;
        while (x * x + y * y < 4.0 && iter++ < MAX_ITERATIONS) {
            double xt = x * x - y * y + x0;
            y = -2 * x * y + y0;
            x = xt;
//            System.out.printf("x = %.2f, y = %.2f ITER=%d\n", x, y, iter);
        }
        return iter < MAX_ITERATIONS ? iter : -1;
    }
}
