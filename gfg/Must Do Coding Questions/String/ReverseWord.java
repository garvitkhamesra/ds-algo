package String;

public class ReverseWord {
    String reverseWords(String S) {
        String[] str = S.split("\\.");
        int l = 0, r = str.length-1;
        while (l < r) {
            String t = str[l];
            str[l] = str[r];
            str[r] = t;
            l++;r--;
        }
        return String.join(".", str);
    }
}
