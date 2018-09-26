package stack;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] days = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j =i+1; j < length; j++) {
                if(temperatures[j]>temperatures[i]){
                    days[i]=j-i;
                    break;
                }
            }
        }
        return days;
    }

    /**
     * 别人更好的解法
     * @param temperatures
     * @return
     */
    public int[] othersSolution(int[] temperatures) {
        int[]res = new int[temperatures.length];
        res[temperatures.length - 1] = 0;
        for(int i = temperatures.length-2; i >= 0;i--){
            int j = i+1;
            //倒序来，当后面的数比前面的数小时，直接找到比后面的数大的数
            //不用依次去遍历
            while(temperatures[j] <= temperatures[i] && res[j] > 0){
                j = j+res[j];
            }
            if (temperatures[j] <= temperatures[i]){
                res[i] = 0;
            }else{
                res[i] = j - i;
            }
        }
        return res;
    }
}
