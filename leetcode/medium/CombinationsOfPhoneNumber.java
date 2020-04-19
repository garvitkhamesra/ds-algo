import java.util.ArrayList;
import java.util.List;

/**
 * Created by dot on 18/4/20 1:27 PM
 * Package: PACKAGE_NAME
 */
public class CombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;

        String[] mapping = new String[] {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        letterCombinationsWithRecursion(result, digits, 0, "", mapping);
        return result;
    }

    private void letterCombinationsWithRecursion(List<String> result, String digits, int iterator,
                                                 String current, String[] mapping) {
        if (iterator == digits.length()) {
            result.add(current);
            return;
        }

        String mappingLetters = mapping[digits.charAt(iterator) - '0'];

        for (int i = 0; i < mappingLetters.length(); i++) {
            letterCombinationsWithRecursion(result, digits, iterator + 1,
                    current + mappingLetters.charAt(i), mapping);
        }
    }
}
