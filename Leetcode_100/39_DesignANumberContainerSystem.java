// url: https://leetcode.com/problems/design-a-number-container-system/

class NumberContainers {

    Map<Integer, Set<Integer>> numMap;
    Map<Integer, Integer> idxMap;

    public NumberContainers() {
        idxMap = new HashMap<>();
        numMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idxMap.containsKey(index)) {
            int num = idxMap.get(index);
            numMap.get(num).remove(index);
            if(numMap.get(num).size() == 0) numMap.remove(num);
        }
        idxMap.put(index, number);
        numMap.putIfAbsent(number, new TreeSet<>());
        numMap.get(number).add(index);
    }
    
    public int find(int number) {
        if(!numMap.containsKey(number)) return -1;
        for(int i: numMap.get(number)) return i;
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
