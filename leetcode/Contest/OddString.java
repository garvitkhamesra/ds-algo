/**
 * Created by dot on 8/3/20 4:36 PM
 * Package: PACKAGE_NAME
 */
public class OddString {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if(n % 2 == 0) {
            for(int i = 0; i < n - 1; i++) sb.append('a');
            sb.append('b');
        } else {
            for(int i = 0; i < n; i++) sb.append('a');
        }
        return sb.toString();
    }
}
