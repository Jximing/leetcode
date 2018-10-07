package Array.Summary;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[index]){
                nums[++index]=nums[i];
            }
        }
        return index+1;
    }
}
