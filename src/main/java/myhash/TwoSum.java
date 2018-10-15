package myhash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        int[] res = new int[2];
        for (int i=0;i<nums.length;i++){
            int find = target - nums[i];
            if(map.containsKey(find)){
                res[0]=i;
                res[1] = map.get(find);
                return res;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
