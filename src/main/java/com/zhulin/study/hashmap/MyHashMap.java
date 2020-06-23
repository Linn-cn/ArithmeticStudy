package com.zhulin.study.hashmap;

/**
 * @author 南街
 * @program ArithmeticStudy
 * @classname MyHashMap
 * @description 手写简单的HashMap
 * @create 2020-03-06 18:40
 **/
public class MyHashMap<K,V> {

    private Entry[] table;
    private static Integer CAPACITY = 8;
    private int size = 0;

    public MyHashMap() {
        this.table = new Entry[CAPACITY];
    }

    public int size(){
        return size;
    }

    public Object put(K key,V value){
        int i = key.hashCode() % CAPACITY;
        for (Entry<K,V> entry = table[i]; entry != null;entry = entry.next){
            if (entry.k.equals(key)){
                V oldValue = entry.v;
                entry.v = value;
                return oldValue;
            }
        }
        addEntry(key,value,i);
        return null;
    }

    private void addEntry(K key,V value,int i) {
        Entry<K, V> entry = new Entry<>(key,value,table[i]);
        table[i] = entry;
        size++;
    }

    public Object get(K key){
        int i = key.hashCode() % CAPACITY;

        for (Entry<K,V> entry = table[i]; entry != null;entry = entry.next){
            if (entry.k.equals(key)){
                return entry.v;
            }
        }
        return null;
    }


    class Entry<K,V>{
        private K k;
        private V v;
        private Entry<K,V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public K getK() {
            return k;
        }

        public V getY() {
            return v;
        }

        public Entry<K, V> getNext() {
            return next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("周瑜" + i,"老师" + i);
        }
        System.out.println(map.get("周瑜"));
    }
}
