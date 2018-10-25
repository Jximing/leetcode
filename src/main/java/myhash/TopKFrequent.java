package myhash;

import java.util.*;

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(entry);
        }
        for (int i = 0; i < k; i++){
            list.add(pq.poll().getKey());
        }
        return list;
    }

    //top1
    public List<Integer> topKFrequent1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i < min) min = i;
            if (i > max) max = i;
        }

        int[] count = new int[max - min + 1];   // 各个数字出现的频数

        for (int i : nums) {
            count[i - min]++;
        }

        int max_count = Integer.MIN_VALUE;

        for (int i : count) {
            if (i > max_count)
                max_count = i;
        }

        int[] aid = new int[max_count + 1];   // 各个频数所包含的key数

        for (int i : count) {
            if (i > 0) {
                aid[i]++;
            }
        }

        int min_count = 1;
        int curr = 0;
        for (int i = aid.length - 1; i >= 1; i--) {
            if (aid[i] > 0) {
                curr += aid[i];
                if (curr >= k) {
                    min_count = i;
                    break;
                }
            }
        }

        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= min_count) {
                ans.add(i + min);
            }
        }
        return ans;
    }

}
