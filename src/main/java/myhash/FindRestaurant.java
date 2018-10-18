package myhash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        for (int i=0;i<list1.length;i++){
            map.put(list1[i],i);
        }
        int minIndex = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])){
                list.add(list2[i]);
                minIndex = Math.min(minIndex,map.get(list2[i])+i);
                map.put(list2[i],map.get(list2[i])+i);
            }
        }
        List<String> rtn = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            if (map.get(list.get(i))==minIndex){
                rtn.add(list.get(i));
            }
        }
        String[] res = new String[rtn.size()];
        for (int i = 0;i<rtn.size();i++){
            res[i]=rtn.get(i);
        }
        return res;
    }

    public static void main(String[] args){
        FindRestaurant fr = new FindRestaurant();
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        fr.findRestaurant(list1,list2);
    }
}
