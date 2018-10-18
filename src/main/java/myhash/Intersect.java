package myhash;

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
}
