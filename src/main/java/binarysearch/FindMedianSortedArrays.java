package binarysearch;

/**
 * @ClassName FindMedianSortedArrays
 * @Description TODO
 * @Author jxm
 * @Date 2018/11/3 22:17
 * @Version 1.0
 **/
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = 0;
        int n = 0;
        int index = 0;

        while (index<(nums1.length+nums2.length)/2){

            if(nums1[m]<nums2[n]){
                m++;
            }else {
                n++;
            }
            index++;
        }
        return (nums1.length+nums2.length)%2==0?1:2;
    }

}
