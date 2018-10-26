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

    public static void main(String[] args){
        Search s = new Search();
        int[] nums = {-1,0,3,5,9,12};
        System.out.print(s.search(nums,9));
    }
}
