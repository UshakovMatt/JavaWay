public class Lab1 {
    public static double computeArea(Point3d firstPoint, Point3d secondPoint, Point3d thirdPoint){
        double a, b, c, p;
        a = firstPoint.distanceTo(secondPoint);
        b = firstPoint.distanceTo(thirdPoint);
        c = secondPoint.distanceTo(thirdPoint);
        p = (a+b+c)/2;
        return Math.round(Math.sqrt(p*(p-a)*(p-b)*(p-c)) * 1e2) / 1e2;
    }

    public static void main(String[] args){
        var firstPoint = new Point3d(5, 7,5);
        var secondPoint = new Point3d(5, 7, 5);
        var thirdPoint = new Point3d(5, 7, 5);

        System.out.println(computeArea(firstPoint, secondPoint, thirdPoint));
    }
}
