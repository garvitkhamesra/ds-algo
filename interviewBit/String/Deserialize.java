package String;

import java.util.ArrayList;

public class Deserialize {
    public ArrayList<String> deserialize(String A) {
        ArrayList<String> res = new ArrayList<>();
        String[] a = A.split("~");
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            int j = s.length();
            for (int k = s.length()-1; k >= 0; k--) {
                if (Character.isDigit(s.charAt(k))) j--;
                else break;
            }
            res.add(s.substring(0, j));
        }
        return res;
    }
}
