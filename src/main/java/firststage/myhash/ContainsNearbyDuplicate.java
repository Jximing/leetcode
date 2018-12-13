package firststage.myhash;

import java.util.HashMap;
import java.util.Map;

public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null||nums.length==0||k<=0){
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i];
            int j = i+1;
            int length = Math.min(j+k,nums.length);
            for (;j<length;j++){
                if(temp==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        if(k < 0 || nums.length > 1000)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                if(k >= i - map.get(nums[i])) return true;
            }
            map.put(nums[i], i);
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i]>nums[j])
                    break;
                else if (nums[i] == nums[j]) {
                    if((i-j)<=k)
                        return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        ContainsNearbyDuplicate cnd = new ContainsNearbyDuplicate();
        int[] nums = {9,2,9,4,3,1};
        System.out.print(cnd.containsNearbyDuplicate2(nums,2));
    }
}
