package data.struct.lru;

import java.util.HashMap;

/**
 * 146. LRU 缓存机制
 * Least Recently Used  (最近最少使用)
 */
public class LRUCache {
    // key -> Node(key,val)
    private HashMap<Integer,Node> map;
    // Node(k1,v1) <-> Node(k2,v2) ...
    private DoubleList cache;
    // 最大容量
    private int cap;


    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleList();
    }

    public int get(int key) {
        if(!this.map.containsKey(key)) {
            return -1;
        }
        // 提升为最近使用的
        this.makeRecently(key);
        return this.map.get(key).value;
    }

    public void put(int key,int val) {
        if(this.map.containsKey(key)) { // 包含 就先删除在插入
            this.deleteKey(key);
            this.addRecently(key,val);
            return;
        }
        if(cap==cache.size()) { // 满了吧最近未使用的删除
            this.removeLeastRecently();
        }
        this.addRecently(key,val);
    }

    // 将某个节点提升为最近使用的
    private void makeRecently(int key) {
        Node node = map.get(key);
        // 删除该节点
        this.cache.remove(node);
        // 插入到最后
        this.cache.addLast(node);
    }

    // 添加最近使用的节点
    private void addRecently(int key,int val) {
        Node node = new Node(key,val);
        this.cache.addLast(node);
        // 添加映射
        this.map.put(key,node);
    }

    // 删除某个节点
    private void deleteKey(int key) {
        Node node = map.get(key);
        this.cache.remove(node);
        this.map.remove(key);
    }

    // 删除最久未使用的元素
    private void removeLeastRecently() {
        Node node = this.cache.removeFirst();
        int deleteKey = node.key;
        this.map.remove(deleteKey);
    }
}
