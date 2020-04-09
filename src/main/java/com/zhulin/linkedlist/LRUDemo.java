package com.zhulin.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 利用LinkedHashMap实现LRU
 */
class SimpleCache<K, V> extends LinkedHashMap<K, V> {

    private int limit;

    public SimpleCache(int limit) {
        super(Math.max((int) (limit/0.75f) + 1, 16), 0.75f, true);
        this.limit = limit;
    }

    public boolean exists(K key) {
        return containsKey(key);
    }

    /**
     * 判断节点数是否超限
     * @param eldest
     * @return 超限返回 true，否则返回 false
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }
}

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname LRUDemo
 * @description 手写LRU算法
 * @create 2020-03-27 13:33
 **/
public class LRUDemo {
    public static void main(String[] args) {
        SimpleCache<Integer, Integer> cache = new SimpleCache<>(3);

        for (int i = 0; i < 10; i++) {
            cache.put(i, i * i);
        }

        System.out.println("插入10个键值对后，缓存内容：");
        System.out.println(cache + "\n");

        System.out.println("访问键值为7的节点后，缓存内容：");
        cache.get(7);
        System.out.println(cache + "\n");

        System.out.println("插入键值为1的键值对后，缓存内容：");
        cache.put(1, 1);
        System.out.println(cache);

    }

}
