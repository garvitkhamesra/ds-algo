package String;

public class PalindromicString {
    public int isPalindrome(String A) {
        int i = 0, j = A.length()-1;
        A = A.toLowerCase();
        while (i < j) {
            if (!Character.isLetterOrDigit(A.charAt(i))) {
                i++;
                continue;
            }

            if (!Character.isLetterOrDigit(A.charAt(j))) {
                j--;
                continue;
            }
            if (A.charAt(i) != A.charAt(j)) {
                return 0;
            } else {
                i++;j--;
            }
        }
        return 1;
    }
}
