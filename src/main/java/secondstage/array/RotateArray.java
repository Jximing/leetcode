package secondstage.array;

/**
 * @ClassName RotateArray
 * @Description 旋转图像
 * @Author mingjie
 * @Date 2018/12/13 11:37 PM
 * @Versrion 1.0
 **/
public class RotateArray {

    public void rotate(int[][] matrix) {

        int length = matrix.length;

        // 调换对角元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][length - i - 1];
                matrix[length - j - 1][length - i - 1] = tmp;
            }
        }

        // 调换列元素
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = tmp;
            }
        }
    }


    public void rotate1(int[][] matrix) {
        rotate2(matrix, 0, 0, matrix.length);
    }

    //从外层依次转90度
    public static void rotate2(int[][] matrix, int f_x, int f_y, int length) {
        int tem;
        if (length <= 1) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            tem = matrix[length - 1 + f_x - i][f_y];
            matrix[length - 1 + f_x - i][f_y] = matrix[length - 1 + f_x][length - 1 + f_y - i];
            matrix[length - 1 + f_x][length - 1 + f_y - i] = matrix[i + f_x][length - 1 + f_y];
            matrix[i + f_x][length - 1 + f_y] = matrix[f_x][i + f_y];
            matrix[f_x][i + f_y] = tem;
        }
        rotate2(matrix, f_x + 1, f_x + 1, length - 2);
    }


}
