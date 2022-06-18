import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//1
public class Task04 {
    public static String sevenBoom(int[] a) {
        boolean f = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 7) f = true;
        }
        if (f) return "Boom!";
        else return "there is no 7 in the array";
    }
    //2
    public static boolean cons(int[] a) {
        boolean f = false;
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] + 1 == a[i + 1]) f = true;
            else f = false;
        }
        return f;
    }
    //3
    public static String unmix(String text) {
        char[] a = text.toCharArray();
        for (int i = 1; i < a.length; i += 2) {//???????????
            char tmp = a[i - 1];
            a[i - 1] = a[i];
            a[i] = tmp;
        }
        return new String(a);
    }
    //4
    public static String noYelling(String text) {
        if (text.length() == 0 || text.charAt(text.length() - 1) != '?' && text.charAt(text.length() - 1) != '!')
            return text;
        int k = 0;
        for (int i = text.length() - 1; i >= 0; i--)
            if (text.charAt(i) == '?' || text.charAt(i) == '!') k++;
            else break;
        return text.substring(0, text.length() - k + 1);
    }
    //5
    public static String xPronounce(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("x")) words[i] = "ecks";
            else if (words[i].startsWith("x")) words[i] = words[i].replaceFirst("x", "z");
            words[i] = words[i].replace("x", "cks");
        }
        return String.join(" ", words);
    }
    //6
    public static int largestGap(int[] a) {
        Arrays.sort(a);
        int max = a[0];
        int k = 0;
        for (int i = 0; i < a.length - 1; i++) {
            if (max < Math.abs(a[i] - a[i + 1])) {
                max = Math.abs(a[i] - a[i + 1]);
                k = i;
            }
        }
        System.out.print("Largest gap between " + a[k] + " and " + a[k + 1] + " is ");
        return max;
    }
    //7
    public static String revInt(int n) {
        String s = Integer.toString(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        Arrays.sort(arr);
        int pow = 1, res = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            res += arr[i] * pow;
            pow *= 10;
        }
        System.out.print(n + " -> ");
        if (n - res < 0) return "0";
        else return Integer.toString(n - res);
    }
    //8
    public static String commonLastVowel(String text) {
        text = text.toLowerCase().replaceAll("[,.!?:;-]+", "");
        List<String> s = Arrays.asList("euioay".split(""));
        String[] w = text.split(" ");
        HashMap<Integer, String> map = new HashMap<>();
        int k = 0;
        for (String t : w) {
            String v = t.substring(t.length() - 1);
            if (s.contains(v)) {
                map.put(k, v);
                k++;
            }
        }
        return map.get(k - 1);
    }
    //9
    public static String memeSum(int n, int m) {
        String s = Integer.toString(n);
        String c = Integer.toString(m);
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        int a = Math.max(s.length(), c.length());
        if (a == s.length()) arr2.add(0);
        else arr1.add(0);
        for (int i = 0; i < s.length(); i++) arr1.add(Character.getNumericValue(s.charAt(i)));
        for (int i = 0; i < c.length(); i++) arr2.add(Character.getNumericValue(c.charAt(i)));
        int[] rez = new int[a];
        for (int i = 0; i < a; i++) {
            rez[i] = arr1.get(i) + arr2.get(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : rez) sb.append(i);
        return sb.toString();
    }
    //10
    public static String unrepeated(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.toCharArray().length; i++)
            if (!text.substring(0, i).contains(text.charAt(i) + "")) sb.append(text.charAt(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sevenBoom(new int[]{8, 6, 33, 100}));
        System.out.println(cons(new int[]{5, 1, 4, 3, 2}));
        System.out.println(unmix("abcde"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println(xPronounce("Inside the box was a xylophone x"));
        System.out.println(largestGap(new int[]{14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7}));
        System.out.println(revInt(665));
        System.out.println(commonLastVowel("OOI UUI EEI AAI"));
        System.out.println(memeSum(1222, 30277));
        System.out.println(unrepeated("hello"));
    }
}