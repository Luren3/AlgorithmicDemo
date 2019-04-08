package com.sflin.algorithmic.stack;

import java.util.*;

/**
 * Created by MagicFrost
 *
 *  扁平化嵌套列表迭代器
 *
 *  示例
 *
 *  输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 */
public class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        add(nestedList);
    }

    private void add(List<NestedInteger> nestedList){
        for (NestedInteger nestedInteger:nestedList){
            if (nestedInteger.isInteger()){
                queue.offer(nestedInteger.getInteger());
            }else {
                add(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
