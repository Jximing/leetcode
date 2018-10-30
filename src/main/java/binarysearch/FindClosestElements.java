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

    /*
     * @Author jxm
     * @Description 更优的解法
     * @Date 23:55 2018/10/30
     * @Param
     * @return
     **/
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        //相当于查找左边应该留出多少位
        int start = 0, end = arr.length - k;
        while (start < end) {
            //每次多跳一点
            int mid = (start + end) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        for (int j = start; j < start + k; j++) {
            list.add(arr[j]);
        }
        return list;
    }
    public static void main(String[] args){
        FindClosestElements fce = new FindClosestElements();
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        System.out.println(fce.findClosestElements(arr,3,5));
    }
}
