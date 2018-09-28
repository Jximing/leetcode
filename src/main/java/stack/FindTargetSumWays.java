package stack;

public class FindTargetSumWays {

    private int num = 0;

    public int findTargetSumWays(int[] nums, int S) {
        int index = 0;
        int sum = 0;
        sum(nums, S, sum, index, 1);
        sum(nums, S, sum, index, -1);
        return num;
    }

    private void sum(int[] nums, int S, int sum, int index, int oprator) {
        sum = sum + oprator * nums[index++];
        if (index == nums.length) {
            if (S == sum) {
                num++;
            }
            return;
        }
        sum(nums, S, sum, index, 1);
        sum(nums, S, sum, index, -1);
    }

    /**
     * 更好的解法
     */
    public int findTargetSumWays1(int[] nums, int S) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        //总和小于S
        if (totalSum < S)
            return 0;
        //总和 和 目标 奇偶性不一的话不可能得到目标至 因为将其中一个数符号改变的话总是加减偶数
        if ((S + totalSum) % 2 == 1)
            return 0;

        //totalSum = target +x;
        //S = target - x;
        //2target =totalSum +S
        //求出数组中有多少种和为target的即可得出答案
        int target = (S + totalSum) / 2;
        int[] memo = new int[target + 1];
        //排除当nums[0] == 0时memo[j] += memo[j - nums[i]]加上了自己本身
        if (nums[0] == 0) {
            //如果值为0 可以为加0或者减0
            memo[0] = 2;
        } else {
            memo[0] = 1;
            //由于未从0开始遍历，所以加上0的时候的值，memo[j] += memo[j - nums[i]];
            for (int i = 1; i <= target; i++) {
                if (nums[0] == i) {
                    memo[i] = 1;
                }
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                //下标相当于数值，值相当于次数
                memo[j] += memo[j - nums[i]];
            }
        }
        return memo[target];
    }
}
