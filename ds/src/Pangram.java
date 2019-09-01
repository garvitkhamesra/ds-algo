import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pangram {

    public static boolean[] checkPangram(String input) {
        boolean[] flag = new boolean[26];
        char[] charSequence = input.toLowerCase().toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(charSequence[i])) flag[charSequence[i] - 'a'] = true;
        }
        return flag;
    }

    public static char[] missingChar(boolean[] flag, String input) {
        char[] missingCharArray = new char[flag.length];
        int i = 0;
        for (int j = 0; j < flag.length; j++) {
            if (!flag[j]) missingCharArray[i++] = (char) ('a' + j);
        }
        return missingCharArray;
    }

    public static void main(String[] args) {
        String input = "The*quick brown f jumps over the lazy dog";
        boolean[] flag = checkPangram(input);
        boolean check = true;
        for (boolean mark: flag) {
            if (!mark) check = false;
        }
        System.out.println(check);

        int count = 0;
        for (boolean item: flag) {
            if (!item) count++;
        }
        if (count == 1) System.out.println("Pangrammatic Lipogram");

        char[] chars = missingChar(flag, input);
        System.out.println(Arrays.toString(chars));


        // Remove all punctuation
        input = input.replaceAll("\\p{Punct}", "");
        System.out.println("Removed punctuation -> " + input);
    }
}
