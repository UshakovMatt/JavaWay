public class task02 {//1
    public static int func1(int n, int w){
        return 2*w - n + 1;
    }//2
    public static String func2(String fullName){
        String[] spiltName = fullName.split(" ");
        return spiltName[1] + " " + spiltName[0];
    }//3
    public static float func3(int price, int perc){
        return price * perc/100;
    }//4
    public static int func4(int[] arr){
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return Math.abs(max - min);
    }//5
    public static int func5(int a, int b, int c){
        if(a == b && a == c)
            return 3;
        if((a == b && a != c) || (a == c && b != c))
            return 2;
        return 0;
    }//6
    public static String func6(String word){
        String reverseWord = "";
        for (int i = 0; i < word.length(); i++){
            reverseWord += word.charAt(word.length() - 1 - i);
        }
        return reverseWord;
    }//7
    public static int func7(int a, int b, int c){
        int max = a;
        int min = a;
        max = Math.max(max, b);
        max = Math.max(max, c);
        min = Math.min(min, b);
        min = Math.min(min, c);
        return max - min;
    }//8
    public static boolean func8(String word){
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.toLowerCase().charAt(i) == 'x')
                countX++;
            if (word.toLowerCase().charAt(i) == 'o')
                countO++;
        }
        return countO == countX;
    }//9
    public static String func9(String word){
        String[] arr = word.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].toLowerCase().equals("bomb"))
                return "DUCK!!!";
        }
        return "Relax, there's no bomb";
    }//10
    public static boolean func10(String str1, String str2){
        int countStr1 = 0;
        int countStr2 = 0;
        for (int i = 0; i < str1.length(); i++){
            countStr1 += (int)str1.charAt(i);
        }
        for (int i = 0; i < str2.length(); i++){
            countStr2 += (int)str2.charAt(i);
        }
        return countStr1 == countStr2;
    }

    public static void main(String[] args){
        System.out.println(func1(2, 3));
        System.out.println(func2("Seymour Butts"));
        System.out.println(func3(1500, 50));
        System.out.println(func4(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(func5(1, 1, 3));
        System.out.println(func6("Hello World"));
        System.out.println(func7(147, 33, 526));
        System.out.println(func8("oxxo"));
        System.out.println(func9("here is no omB"));
        System.out.println(func10("AA", "B@"));
    }
}