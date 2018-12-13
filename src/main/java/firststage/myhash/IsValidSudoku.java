package firststage.myhash;

public class IsValidSudoku {

    public boolean isValidSudoku1(char[][] board) {
        for (int i = 0; i < 9; i++){
            int[] row = new int[9];
            int[] line = new int[9];
            int[] three = new int[9];
            int RowIndex = 3 * (i / 3);
            int ColIndex = 3 * (i % 3);
            for (int j = 0; j < 9; j++){
                char cl = board[i][j];
                char cr = board[j][i];
                if (cl != '.'){
                    line[cl - '1']++;
                    if (line[cl - '1'] >= 2)
                        return false;
                }
                if (cr != '.'){
                    row[cr - '1']++;
                    if (row[cr - '1'] >= 2)
                        return false;
                }
                char c =board[RowIndex + j/3][ColIndex + j%3];
                if (c != '.'){
                    three[c - '1']++;
                    if (three[c - '1'] >=2)
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            row = row / 3 * 3 + 3;
            for (int i = 1; i <= 3; i++) {
                if (!validNine(board, row, i * 3)) {
                    return false;
                }
            }
        }
        return validRow(board);
    }

    private boolean validNine(char[][] subCell, int row, int col) {
        boolean[] b = new boolean[9];
        for (int i = row - 3; i < row; i++) {
            for (int j = col - 3; j < col; j++) {
                if (subCell[i][j] != '.') {
                    if (b[subCell[i][j] - '1']) {
                        return false;
                    } else {
                        b[subCell[i][j] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean validRow(char[][] row) {
        for (int i = 0; i < row.length; i++) {
            boolean[] b = new boolean[9];
            if (!validCol(row[i])) {
                return false;
            }
            for (int j = 0; j < 9; j++) {
                if (row[j][i] != '.') {
                    if (b[row[j][i] - '1']) {
                        return false;
                    } else {
                        b[row[j][i] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean validCol(char[] col) {
        boolean[] b = new boolean[9];
        for (int i = 0; i < col.length; i++) {
            if (col[i] != '.') {
                if (col[i] == '.' || b[col[i] - '1']) {
                    return false;
                } else {
                    b[col[i] - '1'] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsValidSudoku ivs = new IsValidSudoku();
        char[][] board = {{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                          {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                          {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                          {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.print(ivs.isValidSudoku(board));
    }
}
