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

    public static void main(String[] args) {
        System.out.println(PalindromicPermutation.isPermutationOfPalindrome("tacsdg sdcat"));
    }
}

