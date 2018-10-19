package myhash;

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
}
