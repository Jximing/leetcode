package binerytree;

import java.util.Arrays;

/**
 * @ClassName KthLargest
 * @Description Kth Largest Element in a Stream
 * @Author jxm
 * @Date 2018/12/1 19:41
 * @Version 1.0
 **/
public class KthLargest {

    int kth;

    int[] data;

//    public KthLargest(int k, int[] nums) {
//        this.kth = k;
//        this.data = new int[k];
//        if (nums != null&&nums.length!=0) {
//            Arrays.sort(nums);
//            if(k>nums.length){
//                int length = nums.length;
//                for (int i=k-1;i>=0;i--){
//                    if(length==0){
//                        data[i] = Integer.MIN_VALUE;
//                    }else {
//                        data[i]=nums[--length];
//                    }
//                }
//            }
//            for (int i = nums.length - 1; kth > 0&&i>=0; i--) {
//                data[--kth] = nums[i];
//            }
//        }
//    }

    public int add(int val) {
        if(kth!=0){
            data[--kth] = val;
            Arrays.sort(data);
        }else {
            if(data.length==1){
                data[0] = Math.max(data[0],val);
            }
            for (int i = data.length - 1; i >=0; i--) {
                if (val > data[i]) {
                    for (int j =0;j<i;j++){
                        data[j] = data[j+1];
                    }
                    data[i] = val;
                    break;
                }
            }
        }
        return data[0];
    }


    /*
     * @Author jxm
     * @Description //其它方法
     * @Date 0:57 2018/12/2
     * @Param
     * @return
     **/

    private final int[] heap;
    private final int k;
    private int size;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new int[k + 1];
        for (int n : nums) add1(n);
    }

    public int add1(int val) {
        if (size < k) {
            // Build a min heap from the first k elements.
            heap[++size] = val;
            // Promote val to the top.
            for (int i = size; i > 1 && heap[i] < heap[i >>> 1];) swap(i, i >>>= 1);
        } else if (val > heap[1]) {
            // If val is greater than the minimum then it replaces the minimum.
            // Otherwise it's ignored.
            heap[1] = val;
            // Move val to the bottom.
            sink();
        }
        return heap[1];
    }

    private void sink() {
        int i = 1;
        while (i << 1 <= size) {
            // 2i and 2i+1 are the children of i.
            int j = i << 1;
            // If 2i+1 exists, choose the smallest of 2i and 2i+1.
            if (j < size && heap[j + 1] < heap[j]) j++;
            // If there are no children less than i then we're done.
            if (heap[i] <= heap[j]) break;
            // Otherwise swap i and the smallest of its children.
            swap(i, i = j);
        }
    }

    private void swap(int i, int j) {
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

}