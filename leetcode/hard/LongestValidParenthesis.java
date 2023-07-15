package hard;

import java.util.Stack;

public class LongestValidParenthesis {
    public static int longestValidParentheses(String s) {
        int res = 0; // Initial length
        Stack<Integer> st = new Stack<>(); // Initialize the stack
        st.push(-1); // Added to handle edge case
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                if (st.size() > 1 && s.charAt(st.peek()) == '(') {
                    st.pop();
                    res = Math.max(res,i - st.peek()); // calc the length of valid string
                } else {
                    st.push(i); // To handle invalid scenarios
                }
            }
        }
        return res;
    }

    public static int longestValidParenthesesDP(String str) {
        int res = 0;
        int dp[] = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') { // Whenever we encounter ')'
                if (str.charAt(i - 1) == '(') { // We need to check if the character before is '(' or not
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2; // if true we just add 2 to the previously calculated length of valid substring
                } else if (i - dp[i - 1] > 0 && str.charAt(i - dp[i - 1] - 1) == '(') {
                    // i - dp[i-1] -1 means we are pointing to the index just before we had a valid string,
                    // because the dp[i-1] has the valid substring length
                    // once we at that index we need to check that the index is having '('
                    // this means we have addition to our valid substring
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    public int longestValidParenthesesWithoutExtraSpace(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) { // string is valid
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) { // string becomes invalid
                left = right = 0;
            }
        }

        // Second iteration is to make sure if we had left more from left -> right which when traverse from right -> left
        // can contribute to max length
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) { // string is valid
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) { // String becomes invalid
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())))"));
        System.out.println(longestValidParenthesesDP(")()())))"));
    }
}
