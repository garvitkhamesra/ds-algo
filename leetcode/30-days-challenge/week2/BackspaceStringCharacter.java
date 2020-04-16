package week2;

/**
 * Created by dot on 9/4/20 2:31 PM
 * Package: PACKAGE_NAME
 */
public class BackspaceStringCharacter {
    public boolean backspaceCompare(String S, String T) {
        if (S.equals(T)) return true;
        StringBuilder s = new StringBuilder(S);
        StringBuilder t = new StringBuilder(T);
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                s.deleteCharAt(i);
                if (i - 1 >= 0) {
                    s.deleteCharAt(i-1);
                    i--;
                }
                i--;
            }
            i++;
        }
        i = 0;
        while (i < t.length()) {
            if (t.charAt(i) == '#') {
                t.deleteCharAt(i);
                if (i - 1 >= 0) {
                    t.deleteCharAt(i-1);
                    i--;
                }
                i--;
            }
            i++;
        }
        S = s.toString().replace("#", "");
        T = t.toString().replace("#", "");

        return S.equals(T);
    }

    /*public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }


    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }*/
}
