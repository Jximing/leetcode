package Array.Summary;

public class RotateArray {
    //第一种
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int times = k % nums.length;
        for (int i = 0; i < times; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    //第二种
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = k % nums.length;
        int[] temp = new int[length];
        for (int i=0;i<length;i++){
            temp[i]=nums[nums.length-length+i];
        }
        for (int j = nums.length - 1; j >=length; j--) {
            nums[j] = nums[j - length];
        }
        for (int i = 0; i <length; i++) {
            nums[i] = temp[i];
        }
    }

    //第三种
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        //将整个数组旋转
        reverse(nums, 0, nums.length - 1);
        //旋转0到k-1将后面的转正
        reverse(nums, 0, k - 1);
        //将剩下的转正
        reverse(nums, k, nums.length - 1);
    }

    //根据start和end将数组对称
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        RotateArray ra = new RotateArray();
        int[] nums = {1,2,3};
        ra.rotate1(nums,2);
    }
}
