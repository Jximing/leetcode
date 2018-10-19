package myhash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        List<List<String>> res= new LinkedList<>();
        for (List<String> l : map.values()){
            res.add(l);
        }
        return res;
    }
    private String toStringKey(int[] inkey){
        String s = "";
        for (int c:inkey){
            s= s+((char)c+'a');
        }
        return s;
    }
}
