package firststage.myhash;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        Map<String,List<String>> map = new HashMap<>();
        for (String s:strs){
            String key = "";
            char[] arr = s.toCharArray();
            int[] inkey = new int[26];
            for (int c:arr){
                inkey[c-'a']++;
                key=toStringKey(inkey);
            }
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else {
                List<String> list=new LinkedList<>();
                list.add(s);
                map.put(key,list);
            }
        }
        return new ArrayList<>(map.values());
    }
    private String toStringKey(int[] inkey){
        String s = "";
        for (int c:inkey){
            s= s+((char)c+'a');
        }
        return s;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
