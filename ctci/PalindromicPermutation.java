public class PalindromicPermutation {
    /*
        Question Explanation
            The question is to check if the given string is a permutation of the palindrome
        Solution approaches
            1. We can get the count of each character and only 1 or less should be odd
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
            2. By using bit vector
                1.1 Time Complexity : O(N)
                1.2 Space Complexity : O(N)
    */

    public static boolean isPermutationOfPalindrome(String str) {
        str = str.toLowerCase();
        int count = 0;
        int[] hashTable = new int[128];
        for (char ch : str.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                hashTable[ch]++;
                if (hashTable[ch] % 2 == 1) count++;
                else count--;
            }
        }
        return count <= 1;
    }

    public static boolean isPermutationOfPalindromeBitVector(String str) {
        str = str.toLowerCase();
        int bitVector = 0;
        for (char ch : str.toCharArray()) {
            int val = getCharacterValueWithZeroIndex(ch);
            int mask = (1 << val);
            if (val >= 0) {
                if ((bitVector & mask) == 0) bitVector |= mask;
                else bitVector &= ~mask;
            }
        }
        return bitVector == 0 | checkIfOnly1BitMasked(bitVector);
    }

    private static boolean checkIfOnly1BitMasked(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private static int getCharacterValueWithZeroIndex(char ch) {
        int val = ch - 'a';
        if (val >= 0) return val;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(PalindromicPermutation.isPermutationOfPalindrome("tacsdgf sdcat"));
        System.out.println(PalindromicPermutation.isPermutationOfPalindromeBitVector("tacsdgf sdcat"));
    }
}

