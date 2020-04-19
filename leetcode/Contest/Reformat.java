import java.util.Arrays;

/**
 * Created by dot on 19/4/20 11:12 AM
 * Package: PACKAGE_NAME
 */
public class Reformat {
    public String reformat(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = "";

        if (s.length()%2 == 0) {
            int d = 0, c = 0;
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    d++;
                } else {
                    c++;
                }
            }

            if (d == c) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                return giveString(chars, 0, chars.length/2);

            } else {
                return "";
            }
        } else {
            int d = 0, c = 0;
            for (char ch : s.toCharArray()) {
                if (Character.isDigit(ch)) {
                    d++;
                } else {
                    c++;
                }
            }

            if (d - c == 1 || c - d == 1) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);

                if (d > c) {
                    return giveString(chars, 0, chars.length/2 + 1);
                } else {
                    return giveString(chars, 0, chars.length/2);
                }
            } else {
                return "";
            }
        }

    }

    private static String giveString(char[] chars, int i, int j) {
        char[] res = new char[chars.length];
        int k = 0;
        int mid = j;
        if (mid == chars.length/2) {
            while (k < chars.length) {
                if (j < chars.length)
                    res[k++] = chars[j++];
                if (i < mid)
                    res[k++] = chars[i++];
            }
        } else {
            while (k < chars.length) {
                if (i < mid)
                    res[k++] = chars[i++];
                if (j < chars.length)
                    res[k++] = chars[j++];
            }
        }

        return new String(res);
    }
}
