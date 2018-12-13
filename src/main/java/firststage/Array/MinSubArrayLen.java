package firststage.Array;

public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0, j = i;
            while (sum < s && j < nums.length - 1) {
                sum += nums[j++];
            }
            if (s <= sum) {
                minlen = Math.min(minlen, j - i);
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }


    //更好的解法
    public int minSubArrayLen1(int s, int[] nums) {
        int win = 0;
        int temp = 0;
        //先从头开始找到刚好比s大的连续数组
        for (int i = 0; i < nums.length && temp < s; i++) {
            temp += nums[i];
            win++;
        }
        if (temp < s) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            //去掉第一个
            temp = temp - nums[i - 1];
            //如果去掉一个还大的话长度就减一
            if (temp >= s) {
                win--;
                //遍历完
            } else if (i + win - 1 >= nums.length){
                break;
                //加上最后一个
            } else {
                temp += nums[i + win - 1];
            }
        }
        return win;
    }
}
