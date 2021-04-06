package data.struct.lfu;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 460. LFU 缓存
 * Least Frequently Used 最不经常使用
 */
public class LFUCache {

    // key到val的映射
    HashMap<Integer,Integer> key2Val;
    // key到freq的映射
    HashMap<Integer,Integer> key2Freq;
    // freq到key列表的映射
    HashMap<Integer, LinkedHashSet<Integer>> freq2Keys;

    // 记录最小频次
    int minFreq;
    // 记录最大容量
    int cap;

    public LFUCache(int capcity) {
        this.cap = capcity;
        this.key2Val = new HashMap<>();
        this.key2Freq = new HashMap<>();
        this.freq2Keys = new HashMap<>();
        this.minFreq=0;
    }

    public int get(int key) {
        if(!this.key2Val.containsKey(key)) { // 不存在
            return -1;
        }
        // 存在 需要将对应频次累加
        increaseFreq(key);
        return this.key2Val.get(key);
    }

    public void put(int key,int value) {
        if(this.cap<=0) {
            return;
        }
        // 存在
        if(this.key2Val.containsKey(key)) {
            this.key2Val.put(key,value); // 更新值 增加key的反问频次
            increaseFreq(key);
            return;
        }
        if(this.key2Val.size()>=this.cap) { // 超出容量 删除
            removeMinFreqKey();
        }
        this.key2Val.put(key,value);
        this.key2Freq.put(key,1);
        this.freq2Keys.putIfAbsent(1,new LinkedHashSet<>());
        this.freq2Keys.get(1).add(key);
        this.minFreq = 1;
    }

    /**
     * 对应key的访问频次加1
     * @param key
     */
    private void increaseFreq(int key) {
        int freq = this.key2Freq.get(key);
        this.key2Freq.put(key,freq+1);
        this.freq2Keys.get(freq).remove(key);
        this.freq2Keys.putIfAbsent(freq+1,new LinkedHashSet<>());
        this.freq2Keys.get(freq+1).add(key);
        // 如果freq对应列表空了 移除freq
        if(freq2Keys.get(freq).isEmpty()) {
            freq2Keys.remove(freq);
            if(freq==this.minFreq) {
                this.minFreq++;
            }
        }
    }

    /**
     * 删除最小频次的key 如果存在多个key，就删除旧的
     */
    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keys = this.freq2Keys.get(this.minFreq);
        Integer deletedKey = keys.iterator().next();  // 第一个key就是最旧的key
        keys.remove(deletedKey);
        if(keys.isEmpty()) {
            this.freq2Keys.remove(this.minFreq);
        }
        this.key2Val.remove(deletedKey);
        this.key2Freq.remove(deletedKey);
    }
}
