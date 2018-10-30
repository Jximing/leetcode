package binarysearch;

public class FindMin {

    public int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int left=0;
        int right = nums.length-1;
        while (left<right){
            int mid = left + (right - left)/2;
            if(nums[mid]<findLeft(nums,mid)){
                return nums[mid];
            }else if(nums[mid]>nums[nums.length-1]) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return nums[left];
    }

    private int findLeft(int[] nums,int index){
        if(index==0){
            return nums[nums.length-1];
        }else {
            return nums[index-1];
        }
    }

    public static void main(String[] args){
        FindMin fm = new FindMin();
        int[] nums = {3,4,5,1,2};
        System.out.print(fm.findMin(nums));
    }
}
