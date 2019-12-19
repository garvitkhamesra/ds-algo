package easy.strings;

/**
 * User: garvit
 * Date: 19/12/19 9:15 AM
 */

/*
Reverse Integer
https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
*/

public class ReverseInteger {
    public int reverse(int x) {
        long ans = 0L;
        while (x != 0) {
            ans = ans * 10 + x % 10;
            x = x/10;
        }
        if (Integer.MAX_VALUE < ans || Integer.MIN_VALUE > ans) return 0;
        return (int) ans;
    }
}
