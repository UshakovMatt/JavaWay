package com.company;

import java.util.ArrayList;
import java.util.Arrays;
//1
public class Task3 {
    public static String millionsRounding(String[] countryname, int[] popul) {
        int mil;
        StringBuilder forreturn = new StringBuilder();
        for (int i = 0; i < countryname.length; i++) {
            mil = popul[i] % 1000000;
            popul[i] = popul[i] / 1000000;
            if (mil >= 500000) popul[i] = popul[i] + 1;//?
            popul[i] = popul[i] * 1000000;
            forreturn.append(countryname[i]).append(" ").append(popul[i]);
        }
        return forreturn.toString();
    }
//2
    public static double[] otherSides(double a) {
        return new double[]{a * 2, (Math.round((Math.sqrt(3) * a) * 1e2)) / 1e2};
    }
//3
    public static String rps(String p1, String p2) {
        if ((p1.equals("scissors") && p2.equals("paper")) || (p1.equals("paper") && p2.equals("rock")))
            return "Player 1 wins";
        else if ((p2.equals("scissors") && p1.equals("paper")) || (p2.equals("paper") && p1.equals("rock")))
            return "Player 2 wins";
        return "TIE";
    }
//4
    public static int warOfNumbers(int[] a) {
        int ch = 0;
        int nch = 0;
        for (int i : a)
            if (i % 2 == 0) ch = ch + i;
            else nch = nch + i;
        return Math.abs(ch - nch);
    }
//5
    public static String reverseCase(String text) {
        StringBuilder sb = new StringBuilder();
        for (char i : text.toCharArray()) {
            if (Character.isLowerCase(i)) sb.append(Character.toUpperCase(i));
            else sb.append(Character.toLowerCase(i));
        }
        return sb.toString();
    }
//6
    public static String inatorInator(String text) {
        String[] s = "euioay".split("");
        boolean v = false;
        char a = text.charAt(text.length() - 1);
        for (String el : s) v |= Character.toLowerCase(a) == el.charAt(0);
        return text + ((v ? "-" : "") + "inator " + text.length() + "000");
    }
//7
    public static boolean doesBrickFit(double a, double b, double c, double w, double h) {
        double[] k = {a, b, c};
        Arrays.sort(k);
        return (k[0] <= Math.max(w, h) && k[1] <= Math.min(w, h));
    }
//8
    public static double totalDistance(double lit, double ras, int pas, boolean kon){
        if (pas > 0) ras += (0.05*pas*ras);
        if (kon) ras += (0.1*ras);
        return Math.round(lit/ras*1e4)/1e2;
    }
//9
    public static double mean(int[] a){
        double k=0;
        for (int i = 0; i<a.length; i++){
            k+=a[i];
        }
        return Math.round(k/a.length*1e2)/1e2;
    }
//10
    public static boolean parityAnalysis(int a){
        String s = Integer.toString(a);
        int k=0;
        for (char c : s.toCharArray()) k += Character.getNumericValue(c);
        return k % 2 == a % 2;
    }
    public static void main(String[] args) {
        System.out.println(millionsRounding(new String[]{"Nice"}, new int[]{942208}));
        System.out.println(Arrays.toString(otherSides(12)));
        System.out.println(rps("paper", "scissors"));
        System.out.println(warOfNumbers(new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}));
        System.out.println(reverseCase("sPoNtAnEoUs"));
        System.out.println(inatorInator("Shrink"));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(totalDistance(36.1, 8.6, 3, true));
        System.out.println(mean(new int[]{1, 0, 4, 5, 2, 4, 1, 2, 3, 3, 3}));
        System.out.println(parityAnalysis(12));

    }
}