package String;

public class Permutation {
    static void permutation(String prefix, String string) {
        int n = string.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + string.charAt(i), string.substring(0, i) + string.substring(i+1, n));
            }
        }
    }
}
