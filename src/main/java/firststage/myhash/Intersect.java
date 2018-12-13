package firststage.myhash;

import java.util.*;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i:nums1){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i:nums2){
            if(map.containsKey(i)&&map.get(i)>0){
                list.add(i);
                map.put(i,map.get(i)-1);
            }
        }
        Integer[] res = new Integer[list.size()];
        return Arrays.stream(list.toArray(res)).mapToInt(Integer::valueOf).toArray();
    }
    //另外的方法
    public int[] intersect1(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)   {
            return new int[0];
        }
        int[] ret1 = new int[Math.max(nums1.length, nums2.length)];
        int len1 = 0;
        boolean[] bl1 = new boolean[ret1.length];
        for (int i=0; i < nums2.length; i++) {
            int start = 0;
            while( (start = find(nums1, nums2[i], start)) != -1 ) {
                if(bl1[start] == false) {
                    ret1[len1++] = nums2[i];
                    bl1[start] = true;
                    break;
                }
                start++;
            }
        }
        int[] ret = new int[len1];
        for (int i=0; i<len1; i++) {
            ret[i] = ret1[i];
        }
        return ret;
    }
    private int find(int[] nums, int val, int i) {
        for (; i < nums.length; i++) {
            if(nums[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
