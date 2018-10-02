package Array;

public class MaxNumsOfArray {

    public int dominantIndex(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                if (i > 0)
                    second = first;
                first = nums[i];
                index = i;
            }
            if (nums[i] < first && nums[i] > second) {
                second = nums[i];
            }
        }
        return first >= 2 * second ? index : -1;
    }

    public static void main(String[] args) {
        MaxNumsOfArray mnoa = new MaxNumsOfArray();
        int[] nums = {0, 0, 3, 2};
        System.out.println(mnoa.dominantIndex(nums));
    }
}
