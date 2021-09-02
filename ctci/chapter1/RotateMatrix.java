package chapter1;

public class RotateMatrix {
    /*
        Question Explanation
            The question is to make the whole row and column as 0 if there is a zero in that row or column
        Solution approaches
            1. With extra space: So we will have 2 additional array which will store that whether the row or col have zero or not
                these arrays will be filled by iterating through array. Once we have this data we will make those row and col as zero
                1.1 Time Complexity : O(N+M)
                1.2 Space Complexity : O(N+M)
            2. In Place: Now instead for creating 2 new arrays we will use 1st row and col to store the col and rows have zero
                and also maintain a variable to check if the first row and col has zero. Then same way nullify all
                1.1 Time Complexity : O(N+M)
                1.2 Space Complexity :
    */

    public static void rotateNinetyDegree(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - j - 1][i]; // i and j places are used like this because while rotating second it goes to 3rd place
                arr[n - j - 1][i] = arr[n - i - 1][n - j - 1];
                arr[n - i - 1][n - j - 1] = arr[j][n - i - 1]; // same goes here
                arr[j][n - i - 1] = temp;
            }
        }
    }

    public static void rotateOnlyWhilePrint(int[][] arr) {
        // printing the matrix on the basis of
        // observations made on indices.
        int n = arr.length;
        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 , 3, 5, 0}, { 1, 2 , 3, 5, 1}, { 0, 2 , 3, 5, 1}, { 1, 2 , 3, 5, 1}, { 2, 7 , 3, 7, 6}  };
        printArray(arr);
        RotateMatrix.rotateNinetyDegree(arr);
        printArray(arr);
        RotateMatrix.rotateOnlyWhilePrint(arr);
    }
}
