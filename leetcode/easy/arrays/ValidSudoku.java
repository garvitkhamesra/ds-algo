package easy.arrays;

/**
 * User: garvit
 * Date: 19/12/19 9:12 AM
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    for (int row = i + 1; row < board.length; row++) {
                        if (board[i][j] == board[row][j]) return false;
                    }

                    for (int col = j + 1; col < board[0].length; col++) {
                        if (board[i][j] == board[i][col]) return false;
                    }

                    int x = (i/3) * 3, y = (j/3) * 3;
                    for (int row = x; row < x+3; row++) {
                        for (int col = y; col < y+3; col++) {
                            if (i != row && j != col && board[i][j] == board[row][col]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

/*
Other Method
public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
*/
