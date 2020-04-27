package secondstage.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mingjie
 * @ClassName YHTriangle
 * @description TODO
 * @date 2020/4/27 15:45
 * @versrion 1.0
 **/
public class YHTriangle {

    public List<List<Integer>> generate(int numRows) {
        //为0，直接返回空数组。
        if (numRows <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = null;

        //递归退出条件，第一行，只有一个数字1
        if (numRows == 1) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
            result.get(0).add(1);
            return result;
        }

        //递归计算，每新增一行都是在上一行的结果上新增。
        result = generate(numRows - 1);

        // ------以下为新增一行的处理逻辑-------

        //拿到列表的最后一行数据，用来计算新增加的一行。
        List<Integer> lastRow = result.get(numRows - 2);

        List<Integer> newRow = new ArrayList<>();
        //开始为1
        newRow.add(1);

        //中间的数据通过上一行的数据得来。
        for (int i = 1; i < numRows - 1; i++) {
            newRow.add(lastRow.get(i - 1) + lastRow.get(i));
        }
        //结束为1
        newRow.add(1);

        //加入新行数据
        result.add(newRow);

        return result;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            helper(list, i);
        }
        return list;
    }

    private void helper(List<List<Integer>> list, int row) {
        List<Integer> il = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            if (i == 0 || i == row - 1) {
                il.add(1);
            } else
                il.add(list.get(row - 1).get(i - 1) + list.get(row - 1).get(i));
        }
        list.add(il);
    }


}
