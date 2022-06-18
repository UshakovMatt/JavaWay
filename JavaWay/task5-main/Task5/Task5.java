import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
//1
public class Task5 {
    public static boolean sameLetterPattern(String str, String str2){
        for(int i = 0; i < str2.length()-1; i++) {
            str2 = str2.replace(str2.charAt(i), str.charAt(i));
        }
        return str.equals(str2);
    }
//2
    public static String spiderVSfly(String spider, String fly){
        int sx = spider.charAt(0) - 65;
        int sy = spider.charAt(1) - 48;
        int fx = fly.charAt(0) - 65;
        int fy = fly.charAt(1) - 48;

        double strategyDist1 = sy + fy;
        double strategyDist2 = Math.abs(sy - fy) + ((sx + fx) % 8) * fy * 0.70710678118;

        String path = "";

        if (strategyDist1 <= strategyDist2) {
            for (int i = 0; i < sy; i++) {
                path += String.valueOf(spider.charAt(0)) + String.valueOf(sy - i) + "-";
            }
            path += "A0-";
            for (int i = 0; i < fy; i++) {
                path += String.valueOf(fly.charAt(0)) + String.valueOf(i+1) + "-";
            }
        } else {
            for (int i = 0; i < Math.abs(sy - fy); i++) {
                path += spider.charAt(0);
                if (sy > fy) path += sy - i;
                else path += sy + i;
                path += '-';
            }
            for (int i = 0; i <= (sx + fx) % 8; i++) {
                path += (char)(65 + (sx + i) % 8) + String.valueOf(fly.charAt(1)) + "-";
            }
        }

        return path.substring(0, path.length() - 1);
    }
//3
    public static int digitCount(int num){
        if(num > 0){ return digitCount(num/10)+1; }
        return 0;
    }
//4
    public static int totalPoints(String arr[], String value){
        int sum = 0;
        boolean flag;
        String str;
        for (int i = 0; i < arr.length; i++){
            flag = true;
            str = value;
            for(int j = 0; j < arr[i].length(); j++){
                if( !str.contains(String.valueOf(arr[i].charAt(j)))){
                    flag = false;
                    break;
                }
                else {str = str.replaceFirst(String.valueOf(arr[i].charAt(j)), " ");}
            }
            if(flag && arr[i].length() == 6){
                sum += arr[i].length()-2 + 50;
            }
            else if (flag){
                sum += arr[i].length()-2;
            }
        }
        return sum;
    }
//5
    public static int longestRun(int array[]){
        int mx = 1;
        int mn = 1;
        int max = 0;
        int min = 0;
        for(int i = 0; i < array.length-1; i++){
            if(array[i] == array[i+1] - 1){
                mx += 1;
            }
            else{mx = 1;}

            if(array[i] == array[i+1] + 1){
                mn += 1;
            }
            else{mn = 1;}
            if(mx > max){ max = mx;}
            if(mn > min){ min = mn;}
        }
        if(min > max){
            return min;
        }
        return max;
    }
//6
    public static String takeDownAverage(String arr[]){
        int array[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = arr[i].replace("%", "");
            array[i] = Integer.parseInt(arr[i]);
        }
        double sum = 0;
        for(int num : array){
            sum += num;
        }
        sum = sum/array.length;
        return String.valueOf(Math.round(sum - 5*(array.length +1))) + "%";
    }
//7
    public static String rearrange(String str){
        String array[] = str.split(" ");
        String tmp = "";
        for(int i = 0; i < array.length; i++){
            for (int j = 1; j <= array.length; j++){
                if(array[i].contains(String.valueOf(j))){
                    tmp = array[i];
                    array[i] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
        str = "";
        for(int i = 0; i < array.length; i++) { str += array[i] + " "; }
        for(int i = 1; i < 10; i++){ str = str.replace(String.valueOf(i), ""); }
        return str;
    }
//8
    public static int maxPossible(int a, int b){
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        for(int i = 0; i < sa.length(); i++){
            int k = -1;
            for (int j = 0; j < sb.length(); j++){
                if( Integer.parseInt(String.valueOf(sb.charAt(j))) > Integer.parseInt(String.valueOf(sa.charAt(i))) ){
                    sa = sa.replaceFirst(String.valueOf(sa.charAt(i)), String.valueOf(sb.charAt(j)));
                    k = j;
                }
            }
            if(k != -1){
                sb = sb.replaceFirst(String.valueOf(sb.charAt(k)), "0");}
        }
        return Integer.parseInt(sa);
    }
//9
    public static String timeDifference(String cityA, String strDate, String cityB){
        SimpleDateFormat formater = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        SimpleDateFormat formater2 = new SimpleDateFormat("yyyy-M-d HH:mm", Locale.ENGLISH);
        Date date;
        try {
            date = formater.parse(strDate);
        } catch (ParseException e) {
            date = new Date(23);
            e.printStackTrace();
        }
        java.util.HashMap<String, Integer> city = new java.util.HashMap<>();
        city.put("Los Angeles", -800);
        city.put("New York", -500);
        city.put("Caracas", -430);
        city.put("Buenos Aires", -300);
        city.put("London", 0);
        city.put("Rome", 100);
        city.put("Moscow", 300);
        city.put("Tehran", 330);
        city.put("New Delphi", 530);
        city.put("Beijing", 800);
        city.put("Canberra", 1000);
        int chA = city.get(cityA) / 100;
        int mnA = city.get(cityA) % 100;
        int chB = city.get(cityB) / 100;
        int mnB = city.get(cityB) % 100;
        date.setHours(date.getHours()+chB-chA);
        date.setMinutes(date.getMinutes()+mnB-mnA);
        return formater2.format(date);
    }
//10
    public static boolean isNew(int num){
        String snum = String.valueOf(num);
        int arr[] = new int[snum.length()];
        if(num < 21){ return true; }
        else{
            for(int i = 1; i < snum.length(); i++){
                arr[i] = Integer.parseInt(String.valueOf(snum.charAt(i)));
            }
            for(int i = 0; i < arr.length-1; i++){
                for(int j = i+1; j < arr.length; j++){
                    if(arr[j] < arr[i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println(spiderVSfly("A4", "C2"));
        System.out.println(digitCount(544));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(longestRun(new int[] {1, 2, 3, 10, 11, 15}));
        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(isNew(30));
    }

}
