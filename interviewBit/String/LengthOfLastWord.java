package String;

public class LengthOfLastWord {

    public int lengthOfLastWord(final String A) {
        String s = A.trim();
        if (s.length() == 0) return 0;
        String[] a = s.split(" ");
        return a[a.length - 1].length();
    }

}
