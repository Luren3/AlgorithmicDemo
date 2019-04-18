package com.sflin.algorithmic.hash;

import java.util.*;

/**
 * Created by MagicFrost
 *
 * 简单哈希与映射算法
 */
public class RandomizedSet {

    private ArrayList<Integer> list;

    private HashMap<Integer,Integer> map;

    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            //每次直接删除会导致list中的元素下标会发生变化，这里先将要删除的元素，
            //用最后一个元素替换掉，再将最后一个元素删掉，达到删除的目的
            if (index != list.size() - 1){
                int last = list.get(list.size() - 1);
                list.set(index,last);
                map.put(last,index);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
