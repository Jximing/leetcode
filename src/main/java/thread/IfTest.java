package thread;

import java.util.Random;

/**
 * @author mingjie
 * @ClassName IfTest
 * @description TODO
 * @date 2021/2/6 19:18
 * @versrion 1.0
 **/
public class IfTest {

    public static void main(String[] args) {
//        test1();
//        test2();
        IfTest it = new IfTest();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(it.exist(board,word));
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        int width = board.length;
        int hight = board[0].length;
        boolean[][] mark = new boolean[width][hight];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < hight; j++) {
                if (board[i][j] == word.charAt(0)
                        && findChar(width, hight, board, mark, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findChar(int width,
                            int hight,
                            char[][] board,
                            boolean[][] mark,
                            int row,
                            int col,
                            int index,
                            String word) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row == width || col == hight || mark[row][col]) {
            return false;
        }
        if (word.charAt(index) == board[row][col]) {
            mark[row][col] = true;
            index++;
            if (findChar(width, hight, board, mark, row + 1, col, index, word) ||
                    findChar(width, hight, board, mark, row - 1, col, index, word) ||
                    findChar(width, hight, board, mark, row, col + 1, index, word) ||
                    findChar(width, hight, board, mark, row, col - 1, index, word)) {
                return true;
            } else {
                mark[row][col] = false;
                return false;
            }
        } else {
            return false;
        }
    }


    public static void test1() {
        int arraySize = 32768;
        int[] data = new int[arraySize];
        Random rnd = new Random(0);
        for (int i = 0; i < arraySize; i++)
            data[i] = rnd.nextInt() % 256;
        long start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (data[j] >= 128)
                    sum += data[j];
            }
        }
        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println(sum);
    }

    public static void test2() {
        int arraySize = 32768;
        int[] data = new int[arraySize];
        Random rnd = new Random(0);
        for (int i = 0; i < arraySize; i++)
            data[i] = rnd.nextInt() % 256;
        long start = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (data[j] >= 128)
                    sum += data[j];
            }
        }
        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println(sum);
    }
}
