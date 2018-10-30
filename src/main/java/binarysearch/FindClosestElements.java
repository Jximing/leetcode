package binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindClosestElements
 * @Description 找到 K 个最接近的元素
 * @Author jxm
 * @Date 2018/10/30 21:48
 * @Version 1.0
 **/
public class FindClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        while (right-left>=k){
            //从两端开始比较，哪段离得远去掉哪端
            if((x-arr[left])>(arr[right]-x)){
                left++;
            }else {
                right--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left;i<=right;i++){
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args){
        FindClosestElements fce = new FindClosestElements();
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        System.out.println(fce.findClosestElements(arr,3,5));
    }
}
