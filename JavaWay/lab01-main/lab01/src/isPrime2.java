public class isPrime2 {
    private static boolean isPolindrom(String targetStr){
        if (targetStr.length() == 1)
            return true;
        for (int i = 0; i < targetStr.length()/2; i++) {
            if (targetStr.toLowerCase().charAt(i) != targetStr.toLowerCase().charAt(targetStr.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String [] arrStr = {"qwq","qwqe","qwqw","o","Trort","qwqsqwq","qwqsqwqa","9123k321"};
        for (String s: arrStr)
            if (isPolindrom(s))
                System.out.printf("%s - полиндром \n", s);
    }
}
