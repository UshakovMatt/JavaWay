import java.awt.geom.Rectangle2D;

public class Mandelbrot extends  FractalGenerator{
    public static final int MAX_ITERATIONS = 2000;

//    getInitialRange - метод позволяет генератору
//    фракталов определить наиболее «интересную» область комплексной плоскости
//    для конкретного фрактала.
    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

//    Метод numIterations реализует итеративную
//    функцию для фрактала Мандельброта.
    @Override
    public int numIterations(double x0, double y0) {
        int iter = 0;
        double x = 0;
        double y = 0;
        while (x * x + y * y < 4.0 && iter++ < MAX_ITERATIONS) {
            double xt = x * x - y * y + x0;
            y = 2 * x * y + y0;
            x = xt;
        }
        return iter < MAX_ITERATIONS ? iter : -1;
    }
}
