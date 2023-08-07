package String;

public class ImplementStrStr {
    public int strStr(final String A, final String B) {
        int i = 0, j = 0, k = 0;
        int n = A.length(), m = B.length();

        StringBuilder temp = new StringBuilder();
        while (j < n && k < m) {
            if (A.charAt(j) == B.charAt(k)) {
                temp.append(A.charAt(j));
                if (temp.toString().equals(B)) return i;
                j++;
                k++;
            } else {
                i++;
                j = i;
                k = 0;
                temp.setLength(0);
            }
        } return -1;
    }
}
