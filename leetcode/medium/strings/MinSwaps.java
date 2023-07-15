package medium.strings;

public class MinSwaps {

    public static int minSwaps(String s) {
        int o = 0, z = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') o++;
            else z++;
        }
        if (Math.abs(z-o) > 1) return -1;

        if (o > z) {
            return helper(s, '1');
        } else if (z > o) {
            return helper(s, '0');
        }

        return Math.min(helper(s, '1'), helper(s, '0'));
    }

    private static int helper(String s, char start) {
        int k = 0;
        for (int j = 0; j < s.length(); j = j + 2) {
            if(s.charAt(j) != start) k++;
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("1110000"));
    }
}
