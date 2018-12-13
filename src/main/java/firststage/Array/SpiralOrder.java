package firststage.Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {


    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int topr = 0;
        int leftc = 0;
        int length = matrix.length*matrix[0].length;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int x=0,y=0;
        int[] dir =null;
        for(int i=0;i<length;i++){
            res.add(matrix[x][y]);
            if(y==col&&x==topr){
                if(dir==dirs[0]){
                    topr++;
                }
                dir = dirs[1];
            }
            if(x==row&&y==col){
                if(dir==dirs[1]){
                    col--;
                }
                dir = dirs[2];
            }
            if(y==leftc&&x==row){
                if(dir==dirs[2]){
                    row--;
                }
                dir = dirs[3];
            }
            if(x==topr && y==leftc && leftc!=col){
                if(dir==dirs[3]){
                    leftc++;
                }
                dir = dirs[0];
            }
            x+=dir[0];
            y+=dir[1];
        }
        return res;
    }

    public static void main(String[] args){
        SpiralOrder so=new SpiralOrder();
        int[][] matrix = {{1},{4},{7}};
        int[][] matrix1 = {{1,2},{3,4}};
        int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix3 = {{1,2,3}};
        so.spiralOrder(matrix).forEach(System.out::println);
        so.spiralOrder(matrix1).forEach(System.out::println);
        so.spiralOrder(matrix2).forEach(System.out::println);
        so.spiralOrder(matrix3).forEach(System.out::println);
    }
}
