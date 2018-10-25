package myhash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    Map<Integer,Integer> map;
    int[] data;
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        data = new int[16];
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        reSize();
        map.put(val,size);
        data[size] = val;
        size++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int key = map.get(val);
        map.put(data[size-1],key);
        map.remove(val);
        data[key] = data[--size];
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
       int key = (int)(size*Math.random());
       return data[key];
    }

    private void reSize(){
        if(size==data.length){
            data=Arrays.copyOf(data,size<<1);
        }
    }
    public static void main(String[] args){
        RandomizedSet randomSet = new RandomizedSet();
        randomSet.insert(0);
        randomSet.insert(1);
        randomSet.remove(0);
        randomSet.insert(2);
        randomSet.remove(1);
        randomSet.getRandom();
    }
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */