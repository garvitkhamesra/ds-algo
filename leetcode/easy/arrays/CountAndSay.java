package arrays;

/**
 * Created by dot on 2/1/20 9:41 AM
 * Package: arrays
 */


public class CountAndSay {

    public static String countAndSay(int n) {
        StringBuilder res = new StringBuilder("1");

        char[] chars = "1".toCharArray();

        for (int i = 1; i < n; i++) {
            res = new StringBuilder();
            int count = 1;
            for (int j = 0; j < chars.length - 1; j++) {
                if (chars[j] == chars[j+1]) {
                    count++;
                } else {
                    res.append(count + "" + chars[j]);
                    count = 1;
                }
            }
            res.append(count + "" + chars[chars.length - 1]);
            chars = res.toString().toCharArray();
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String result = countAndSay(4);
        System.out.println(result);
    }
}
