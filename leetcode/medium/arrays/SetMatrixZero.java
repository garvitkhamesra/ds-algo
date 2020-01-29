package arrays;

/**
 * Created by dot on 29/1/20 11:35 PM
 * Package: arrays
 */
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagRow = false, flagCol = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) flagRow = true;
                    if (j == 0) flagCol = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(flagRow) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if(flagCol) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
