package String;

import java.util.ArrayList;

public class Serialize {
    public String serialize(ArrayList<String> A) {
        String ans = "";
        for (int i = 0; i < A.size(); i++) {
            String s = A.get(i);
            s = s + s.length() + "~";
            ans += s;
        }

        return ans;
    }
}
