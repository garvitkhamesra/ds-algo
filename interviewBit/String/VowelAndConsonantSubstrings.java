package String;

public class VowelAndConsonantSubstrings {
    boolean isVowel(char ch){
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public int solve(String A) {
        int v = 0, c = 0;
        for (char ch: A.toCharArray()) {
            if (isVowel(ch)) {
                v++;
            } else {
                c++;
            }
        }
        return (c*v) % 1000000007;
    }
}
