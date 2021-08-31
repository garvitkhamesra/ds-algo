
public class URLify {

    /*
        Question Explanation
            The question is to add %20 wherever there is a space, the string can have trailing spaces but we are
            given the true length(Length without trailing spaces) as well of the string
        Solution approaches
            1. As strings are immutable and every time we add %20 it will end up creating new string every time,
               but this can be done in 1 pass
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
            2. By using char array, it will take 2 passes to come up with solution
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
    */

    public static String urlify(String str, int trueLength) {
        char[] strArray = str.toCharArray();
        int spaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (strArray[i] == ' ') spaces++;
        }
        int index = trueLength + (spaces * 2);
        char[] strs = new char[index];
        for (int i = trueLength - 1; i >= 0; i--) {
            if (strArray[i] == ' ') {
                strs[index - 1] = '0';
                strs[index - 2] = '2';
                strs[index - 3] = '%';
                index = index - 3;
            } else {
                strs[index - 1] = strArray[i];
                index--;
            }
        }
        return new String(strs);
    }

    public static void main(String[] args) {
        System.out.println(URLify.urlify("Gar vit Khames ra   ",18 ));
    }
}
