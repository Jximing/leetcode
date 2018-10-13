package myhash;

public class MyHashSet {

	private int[] data;
    /** Initialize your data structure here. */
    public MyHashSet() {
        data = new int[1000000];
    }
    
    public void add(int key) {
        data[key] = 1;
    }
    
    public void remove(int key) {
        data[key] = 0;
    }
    
    /** Returns true if this set did not already contain the specified element */
    public boolean contains(int key) {
        return data[key]==1;
    }
    
    private int hash(int key){
    	return key%10000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
