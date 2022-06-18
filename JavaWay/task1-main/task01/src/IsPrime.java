public class IsPrime
{
    public static int convert(int a){
        return a * 60;
    }
    public static int points(int a, int b){
        return a*3 + b*2;
    }
    public static int footballPoints(int a, int b, int c){
        return a*3 + b;
    }
    public static boolean divisibleByFive(int a){
        return (a%5 == 0);
    }
    public static boolean and(boolean a, boolean b){
        return a && b;
    }
    public static int howManyWalls(int n, int w, int h){
        return n / w * h;
    }
    public static int squared(int a) {
        return a * a;
    }
    public static boolean profitableGamble(double prob, int prize, int pay){
        if(prob * prize > pay){
            return true;
        }
        return false;
    }
    public static int frames(int a, int b){
        return a * b * 60;
    }
    public static int mod(int a, int b){
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println(convert(8));
        System.out.println(points(12, 6));
        System.out.println(footballPoints(7,5, 6));
        System.out.println(divisibleByFive(25));
        System.out.println(and(true, true));
        System.out.println(howManyWalls(54, 43, 1));
        System.out.println(squared(5));
        System.out.println(profitableGamble(0.2, 50, 9));
        System.out.println(frames( 5, 6));
        System.out.println(mod(10, 3));
    }
}