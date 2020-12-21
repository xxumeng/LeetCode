package com.leetcode;

import java.util.LinkedHashMap;

class Leet146LRUCache {

    LinkedHashMap<Integer,Integer> cache =new LinkedHashMap<Integer,Integer>();
    private int capacity;
    public Leet146LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            makeRecent(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            makeRecent(key, value);
        }else{
            if(cache.size()+1>this.capacity){
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            cache.put(key, value);
        }

    }
    //    get时，key存在，变成最近使用
    public void makeRecent(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
    //    put时，key存在，变成最近使用，并且变更val
    public void makeRecent(int key, int val){
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
