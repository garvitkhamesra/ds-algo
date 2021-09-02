package chapter1;

public class ZeroMatrix {
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
    public static int[][] createZeroMatrixWithExtraSpace(int[][] arr) {
        boolean[] zerosRow = new boolean[arr.length];
        boolean[] zerosCol = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    zerosRow[i] = true;
                    zerosCol[j] = true;
                }
            }
        }

        for (int i = 0; i < zerosRow.length; i++) {
            if (zerosRow[i]) nullifyRow(i, arr);
        }

        for (int i = 0; i < zerosCol.length; i++) {
            if (zerosCol[i]) nullifyCol(i, arr);
        }
        return arr;
    }

    private static void nullifyCol(int i, int[][] arr) {
        for (int j = 0; j < arr.length; j++) {
            arr[j][i] = 0;
        }
    }

    private static void nullifyRow(int i, int[][] arr) {
        for (int j = 0; j < arr.length; j++) {
            arr[i][j] = 0;
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

    public static int[][] createZeroMatrix(int[][] arr) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] == 0) nullifyRow(i, arr);
        }

        for (int i = 1; i < arr[0].length; i++) {
            if (arr[0][i] == 0) nullifyCol(i, arr);
        }

        if (firstColZero) nullifyCol(0, arr);
        if (firstRowZero) nullifyRow(0, arr);

        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2 , 3, 5, 0}, { 1, 2 , 3, 5, 1}, { 0, 2 , 3, 5, 1}, { 1, 2 , 3, 5, 1} };
        printArray(arr);
        ZeroMatrix.createZeroMatrix(arr);
        printArray(arr);

        int[][] arr1 = { { 1, 2 , 3, 5, 0}, { 1, 2 , 3, 5, 1}, { 0, 2 , 3, 5, 1}, { 1, 2 , 3, 5, 1} };
        printArray(arr1);
        ZeroMatrix.createZeroMatrixWithExtraSpace(arr1);
        printArray(arr1);
    }
}
