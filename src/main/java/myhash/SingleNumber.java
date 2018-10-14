package myhash;

/**
 * @author jiangliuhong
 * @since TODO
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        if(nums.length==0){
            return -1;
        }
        for (int i = 0;i<nums.length;i++){
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(1^2^2);
    }
}
