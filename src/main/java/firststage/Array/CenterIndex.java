package firststage.Array;

public class CenterIndex {
    /**
     * 如果存在中心索引的话，那么左边的和的二倍，加上中心索引的值，即等于数组和
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int lsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (lsum * 2 + nums[i] == sum) {
                return i;
            }
            lsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        CenterIndex ci = new CenterIndex();
        int[] nums = {-1, -1, -1, -1, -1, -1};
        System.out.println(ci.pivotIndex(nums));
    }
}
