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

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        this.data = new int[k];
        if (nums != null&&nums.length!=0) {
            Arrays.sort(nums);
            if(k>nums.length){
                int length = nums.length;
                for (int i=k-1;i>=0;i--){
                    if(length==0){
                        data[i] = Integer.MIN_VALUE;
                    }else {
                        data[i]=nums[--length];
                    }
                }
            }
            for (int i = nums.length - 1; kth > 0&&i>=0; i--) {
                data[--kth] = nums[i];
            }
        }
    }

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

    public static void main(String[] args){
        int k = 3;
        int[] arr = {5,-1};
        KthLargest kthLargest = new KthLargest(k, arr);
        kthLargest.add(2);   // returns 4
        kthLargest.add(1);   // returns 5
        kthLargest.add(-1);  // returns 5
        kthLargest.add(3);   // returns 8
        kthLargest.add(4);   // returns 8
    }

}