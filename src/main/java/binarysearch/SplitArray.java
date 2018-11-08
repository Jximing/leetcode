package binarysearch;

public class SplitArray {

    private boolean guess(int[] nums, long mid, int m) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > mid) {
                m--;
                sum = nums[i];
                if (nums[i] > mid) {
                    return false;
                }
            } else {
                sum += nums[i];
            }
        }
        return m >= 1;
    }

    public int splitArray(int[] nums, int m) {
        long low = 0;
        long high = 0;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            high += nums[i];
        }
        while (low <= high) {
            long mid = low+( high - low ) / 2;
            if (guess(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int)ans;
    }

    public static void main(String[] args){
        SplitArray sa = new SplitArray();
        int[] arr = {2,3,1,2,4,3};
        System.out.println(sa.splitArray(arr,5));
    }
}
