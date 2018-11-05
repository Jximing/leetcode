package binarysearch;

/**
 * @ClassName FindMedianSortedArrays
 * @Description TODO
 * @Author jxm
 * @Date 2018/11/3 22:17
 * @Version 1.0
 **/
public class FindMedianSortedArrays {

    double findMedianSortedArrays(int[] nums1, int nums1Size, int[] nums2, int nums2Size) {
/*
*   基本思想：
*       每一次判断，要找的是第k个数，如果在数组1中，第k/2个数比数组个数还要大，就是用最后一个数
        用两个数组中的第k/2个数进行比较，如果第一个数组中的比第二个数组中的大，就能够将第二个数组中前k/2个数排除在比较范围之外
        这时候，要查找的的就不是第k个数，而是k-k/2个数，
*
*
*   left1：表示数组1的左边界，数组下标
*   left2：表示数组2的左边界，数组下标
*/
        int mid_loc;
        int pos1, pos2, left1 = 0, left2 = 0;
        // 奇偶判断，奇数为真，偶数为假
        boolean flag_odd_even = (nums1Size + nums2Size) % 2 == 0 ? false : true;
        boolean found = false;
        double result=0.0;
        int result_pos;
        // 根据奇偶数，判断中位数是第几位数
        if (flag_odd_even) {
            //如果是奇数
            mid_loc = (nums1Size + nums2Size) / 2 + 1;
        } else {
            //如果是偶数
            mid_loc = (nums1Size + nums2Size) / 2;
        }

        // 判断几种特殊情况，可以直接返回结果
        if (nums1Size == 0 && nums2Size != 0 && nums2Size > mid_loc) {
            if (flag_odd_even) {
                result = nums2[mid_loc - 1];
            } else {
                result = (1.0 * nums2[mid_loc - 1] + nums2[mid_loc]) / 2;
            }
        } else if (nums2Size == 0 && nums1Size != 0 && nums1Size > mid_loc) {
            if (flag_odd_even) {
                result = nums1[mid_loc - 1];
            } else {
                result = (1.0 * nums1[mid_loc - 1] + nums1[mid_loc]) / 2;

            }
        } else {
            // 使用二分法，进行判断
            while (!found) {
                pos1 = (mid_loc / 2) > (nums1Size - left1 - 1) ? nums1Size - 1 : (mid_loc / 2 + left1 - 1);
                pos2 = (mid_loc / 2) > (nums2Size - left2 - 1) ? nums2Size - 1 : (mid_loc / 2 + left2 - 1);

                if (nums1[pos1] >= nums2[pos2]) {
                    // 如果第二个已经到了边界， 在第一个数组中直接找到结果
                    if (pos2 == (nums2Size - 1)) {
                        result_pos = mid_loc - (pos2 - left2 + 1) + left1 - 1;
                        //奇数
                        if (flag_odd_even) {

                            result = nums1[result_pos];
                        } else {
                            result = (1.0 * nums1[result_pos] + nums1[result_pos + 1]) / 2;
                        }
                        found = true;
                    } else {

                        mid_loc -= (pos2 - left2 + 1);
                        left2 = pos2 + 1;
                    }
                } else {
                    // 如果第一个到了边界，直接在第二个数组中找到结果
                    if (pos1 == (nums1Size - 1)) {
                        result_pos = mid_loc - (pos1 - left1 + 1) + left2 - 1;
                        //奇数
                        if (flag_odd_even) {
                            result = nums2[result_pos];
                        } else {
                            result = (1.0 * nums2[result_pos] + nums2[result_pos + 1]) / 2;
                        }
                        found = true;

                    } else {
                        mid_loc -= (pos1 - left1 + 1);
                        left1 = pos1 + 1;
                    }
                }
                if (!found && mid_loc == 1) {

                    if (nums1[left1] <= nums2[left2]) {
                        // 如果是奇数
                        if (flag_odd_even) {
                            result = nums1[left1];
                        } else {
                            // 第一个条件是边界保护
                            if ((left1 < nums1Size - 1) && (nums1[left1 + 1] <= nums2[left2])) {
                                result = (1.0 * nums1[left1] + nums1[left1 + 1]) / 2;
                            } else {
                                result = (1.0 * nums1[left1] + nums2[left2]) / 2;
                            }
                        }
                    } else {
                        if (flag_odd_even) {
                            result = nums2[left2];
                        } else {
                            // 第一个条件是边界保护
                            if ((left2 < nums2Size - 1) && (nums2[left2 + 1] <= nums1[left1])) {
                                result = (1.0 * nums2[left2] + nums2[left2 + 1]) / 2;
                            } else {
                                result = (1.0 * nums2[left2] + nums1[left1]) / 2;

                            }
                        }

                    }
                    found = true;
                }
            }
        }
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length+nums2.length;
        int[] arry = new int[length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i+j<length){
            if(j==nums2.length){
                arry[index++]=nums1[i++];
            }else if(i==nums1.length){
                arry[index++]=nums2[j++];
            }else if(nums1[i]<nums2[j]){
                arry[index++]=nums1[i++];
            }else {
                arry[index++]=nums2[j++];
            }
        }
        if(length%2==0){
            int mid = length/2;
            return (arry[mid]+arry[mid-1])/2.0;
        }else {
            int mid = length/2;
            return arry[mid];
        }
    }

}
