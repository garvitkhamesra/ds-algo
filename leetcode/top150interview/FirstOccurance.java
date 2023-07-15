package top150interview;

public class FirstOccurance {
    public static int strStr(String haystack, String needle) {
        int n = needle.length() - 1, h = haystack.length() - 1, ind = -1;
        if (n > h) return -1;
        while (n >= 0 && h >= 0) {
            if (haystack.charAt(h) == needle.charAt(n)) {
                h--; n--;
            } else {
                n =  needle.length() - 1;
                h--;
            }
            if (n == -1) {
                ind = h+1;
                n =  needle.length() - 1;
                h++;

            }
        }

        return ind;
    }

    public static void main(String[] args) {
        System.out.println(strStr("aaa", "aa"));
    }
}
