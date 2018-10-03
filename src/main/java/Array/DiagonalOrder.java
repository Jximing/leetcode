package Array;

public class DiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return new int[0];
        }
        int col=0;
        int row=0;
        boolean positive = true;
        int length  = matrix.length*matrix[0].length;
        int[] res = new int[length];
        for (int i =0;i<length;i++){
            res[i] = matrix[row][col];
            if((row == 0||col==matrix[0].length-1)&&positive){
                if(col==matrix[0].length-1){
                    row++;
                }else {
                    col++;
                }
                positive = false;
                continue;
            }
            if ((col == 0||row == matrix.length-1) && !positive){
                if(row==matrix.length-1){
                    col++;
                }else {
                    row++;
                }
                positive = true;
                continue;
            }
            if(positive){
                row--;
                col++;
            }else {
                row++;
                col--;
            }
        }
        return res;
    }

    public static void main(String[] args){
        DiagonalOrder dor = new DiagonalOrder();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(dor.findDiagonalOrder(matrix).toString());
    }

}
