package binarysearch;

public class Search {

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        return binarySearch(nums,target,start,end);
    }

    private int binarySearch(int[] nums,int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = (start+end)/2;
        if(nums[mid]==target){
            return mid;
        }else if(nums[mid]<target){
            return binarySearch(nums,target,mid+1,end);
        }else {
            return binarySearch(nums,target,start,mid-1);
        }
    }
    public static void main(String[] args){
        Search s = new Search();
        int[] nums = {-1,0,3,5,9,12};
        System.out.print(s.search(nums,9));
    }
}
