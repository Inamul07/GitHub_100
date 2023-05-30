// url; https://leetcode.com/problems/design-hashset/

class MyHashSet {

    int[] setArray;

    public MyHashSet() {
        setArray = new int[1000001];
    }
    
    public void add(int key) {
        setArray[key] = 1;
    }
    
    public void remove(int key) {
        setArray[key] = 0;
    }
    
    public boolean contains(int key) {
        return setArray[key] == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
