package firststage.binerytree;

/**
 * @ClassName SortedArrayToBST
 * @Description 将有序数组转换为二叉搜索树
 * @Author jxm
 * @Date 2018/12/8 17:10
 * @Version 1.0
 **/
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[right]);
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }

}
