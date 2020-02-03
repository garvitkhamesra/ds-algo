package strings;

/**
 * Created by dot on 29/1/20 11:44 PM
 * Package: strings
 */
public class DecodeAtIndex {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch)) {
                size *= ch - '0';
            } else {
                size++;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(ch)) {
                return Character.toString(ch);
            }

            if (Character.isDigit(ch)) {
                size /= ch - '0';
            } else {
                size--;
            }
        }
        return "";
    }

    public String decodeAtIndexCopied(String S, int K) {
        long size = 0;
        int N = S.length();

        // Find size = length of decoded string
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N-1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }

        throw null;
    }

    public static void main(String[] args) {
        DecodeAtIndex decodeAtIndex = new DecodeAtIndex();
        System.out.println(decodeAtIndex.decodeAtIndex("a2345678999999999999999", 40));
        System.out.println(decodeAtIndex.decodeAtIndexCopied("a2345678999999999999999", 1));
    }
}