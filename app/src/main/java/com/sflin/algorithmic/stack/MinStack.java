package com.sflin.algorithmic.stack;

import java.util.Stack;

/**
 * Created by MagicFrost
 *
 * 初级设计问题算法
 *
 * 题目：最小栈
 *
 * 示例
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStack {

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()){
            minStack.push(x);
        }else {
            int temp = minStack.peek();
            //只有当x小于等于minStack当前栈顶时候存入
            if (temp >= x){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (top() == minStack.peek()){
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
}
