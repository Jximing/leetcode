package firststage.Array.Summary;

import java.util.Arrays;
import java.util.List;

public class YHTriangleII {

    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex+1];
        for (int i=0;i<=rowIndex;i++){
            row[i]=1;
            for (int j =i-1;j>0;j--){
                row[j] = row[j]+row[j-1];
            }
        }
        return Arrays.asList(row);
    }

    public static void main(String[] args){

    }
}
