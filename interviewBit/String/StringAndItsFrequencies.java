package String;

public class StringAndItsFrequencies {
    public String solve(String A) {
        int[] a = new int[26];

        for (char ch: A.toCharArray()) {
            a[ch-'a'] += 1;
        }
        String ans = "";
        for (char ch: A.toCharArray()) {
            if (a[ch-'a'] > 0) {
                ans += ch;
                ans += a[ch-'a'];
                a[ch-'a'] = -1;
            }
        }
        return ans;
    }
}
