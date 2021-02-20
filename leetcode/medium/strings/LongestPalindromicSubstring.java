package strings;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        String str = "";
        String ans = "";
        for (char ch : s.toCharArray()) {
            str += ch;

            for (int i = 0; i < str.length(); i++) {
                for (int j = i; j < str.length(); j++) {
                    if (isPalin(str, i, j)) {
                        String temp = str.substring(i,j+1);
                        if (temp.length() >= ans.length()) {
                            ans = temp;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private static boolean isPalin(String str, int i, int j) {
        while (j >= i && j >= 0 && i < str.length()) {
            if (str.charAt(j) == str.charAt(i)) {
                i++; j--;
            } else return false;
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, maxLen = 1;
        for (int i = 1; i < s.length(); i++) {
            int evenLengthPalin = isPalindrome(s, i-1, i);
            int oddLengthPalin = isPalindrome(s, i-1, i+1);
            int len = Math.max(evenLengthPalin, oddLengthPalin);
            if (len > maxLen) {
                start = i - ((len)/2);
                maxLen = len;
            }

        }
        return s.substring(start, start +  maxLen);
    }

    int isPalindrome(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(j) == str.charAt(i)) {
            i--;j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindromicSubstring.longestPalindrome("asdsad"));
    }
}
