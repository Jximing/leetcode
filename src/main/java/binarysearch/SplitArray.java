package binarysearch;

public class SplitArray {

    public boolean guess(int[] nums, int mid, int m) {

        int sum = 0;
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
        return m == 1;
    }

    public int splitArray(int[] nums, int m) {

        int low = 0;
        int high = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            high += nums[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (guess(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
