package binarysearch;

import java.util.Arrays;

/**
 * @ClassName FindDuplicate
 * @Description 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * @Author jxm
 * @Date 2018/11/3 21:11
 * @Version 1.0
 **/
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }

    public int findDuplicate1(int[] nums) {
        int fast = nums[nums[0]], slow = nums[0];
        //每次fast都比slow多跳一步
        //由于有重复的数字，肯定会形成环链
        while(fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        slow = 0;
        //slow追上fast的位置距重复点的位置正好与起点到重复点位置相同
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        int left = 1;
        int right = nums.length-1;
        while (left<right){
            int mid = left+(right-left)/2;
            int count = 0;
            for (int n:nums){
                if(n<mid){
                    count++;
                }
            }
            if(count<=mid){
                left=mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args){
        FindDuplicate fd = new FindDuplicate();
        int[] nums = {1,2,6,7,9,8,5,4,3,5,5};
        System.out.println(fd.findDuplicate1(nums));
    }
}
