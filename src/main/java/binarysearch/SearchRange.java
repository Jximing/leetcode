package binarysearch;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if (nums == null || nums.length == 0 || nums[0] > target || target > nums[nums.length - 1]) {
            return res;
        }
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[0]==target){
                res[0] = 0;
                break;
            }
            if(nums[mid]<target&&nums[mid+1]==target){
                res[0] = mid+1;
                break;
            }else if(nums[mid]>=target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        right = nums.length-1;
        while (left<=right){
            if(nums[nums.length-1]==target){
                res[1] = nums.length-1;
                break;
            }
            int mid = left+(right-left)/2;
            if(nums[mid]>target&&nums[mid-1]==target){
                res[1] = mid-1;
                break;
            }else if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return res;
    }

}
