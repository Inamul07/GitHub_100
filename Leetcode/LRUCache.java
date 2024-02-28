// url: https://leetcode.com/problems/lru-cache/

class Node {
    int key, val;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "[" + key + "," + val + "]";
    }
}

class LRUCache {

    Map<Integer, Node> map;
    Node head, tail;
    int capacity, size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            removeNode(map.get(key));
            addTail(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).val = value;
            Node node = map.get(key);
            removeNode(node);
            addTail(node);
        } else {
            if(size == capacity) {
                Node rmNode = removeHead();
                map.remove(rmNode.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addTail(newNode);
            if(size != capacity) size++;
        }
    }

    private void addTail(Node newNode) {
        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = tail;
        tail.prev = newNode;
    }

    private Node removeHead() {
        Node node = head.next, next = node.next;
        next.prev = head;
        head.next = next;
        return node;
    }

    private void removeNode(Node node) {
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
