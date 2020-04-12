import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dot on 12/4/20 9:54 AM
 * Package: PACKAGE_NAME
 */
public class StringMatch {
    public List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].contains(words[j]) && i != j) {
                    result.add(words[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
