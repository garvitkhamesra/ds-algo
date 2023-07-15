package Backtracking;

public class MaximalString {
    public static String solve(String A, int B) {
        char[] str = A.toCharArray();
        solver(str, B);
        return String.valueOf(max);
    }

    static int max = Integer.MIN_VALUE;
    private static void solver(char[] str, int swap) {
        if (swap <= 0) return;

        for (int i = 0; i < str.length - 1; i++) {
            for (int j = i+1; j < str.length; j++) {
                if (str[i] < str[j]) {
                    swapedStr(str, i, j);
                    max = Math.max(max, Integer.parseInt(String.valueOf(str)));
                    solver(str, swap-1);
                    swapedStr(str, i, j);
                }
            }
        }
    }

    private static void swapedStr(char[] str, int index, int i) {
        char temp = str[i];
        str[i] = str[index];
        str[index] = temp;
    }

    public static void main(String[] args) {
        System.out.println(solve("254", 2));
    }
}
