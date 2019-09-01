import java.util.Arrays;
import java.util.HashMap;

public class BasicStrings {
    public static void recursiveCopy(char[] s1, char[] s2, int index) {
        s2[index] = s1[index];
        if (index == s1.length-1) return;
        recursiveCopy(s1, s2, ++index);
    }

    public static void iterativeCopy(char[] s1, char[] s2) {
        for (int i = 0; i < s1.length; i++) {
            s2[i] = s1[i];
        }
    }

    static String conversion(char charSet[], String str) {
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < 26; i++) {
            map.put(charSet[i], i);
        }

        String s="";
        for (int i = 0; i < n; i++) {
            char ch = (char) ('a' + map.get(str.charAt(i)));
            s += ch;
        }
        return s;
    }

    public static void main(String[] args) {
        char s1[] = "Hi there".toCharArray();
        char s2[] = new char[s1.length];

        recursiveCopy(s1, s2, 0);
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));

        s1 = "Garvit Khamesra".toCharArray();
        s2 = new char[s1.length];
        iterativeCopy(s1, s2);
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));



        /*Change string to a new character set
        Given a 26 letter character set, which is equivalent to character set of English alphabet
        i.e. (abcd….xyz) and act as a relation. We are also given several sentences and we have to translate them with
        the help of given new character set.*/

        char charSet[] = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        String str = "utta";
        str = conversion(charSet, str);
        System.out.println(str);
    }
}
