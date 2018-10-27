package binarysearch;

public class RotatedArray {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        int last = nums[end];
        if(target==last){
            return end;
        }
        while (start<=end){
            int mid = start+(end  - start)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                if(target>last&&nums[mid]<last){
                    end = mid - 1;
                }else {
                    start = mid+1;
                }
            }else {
                if(nums[mid]>last&&target<last){
                    start = mid+1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
