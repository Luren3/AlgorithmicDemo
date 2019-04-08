package com.sflin.algorithmic.stack;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.*;

/**
 * Created by MagicFrost
 * <p>
 * 中等堆、栈和队列算法
 */
public class MediumStackUtils {

    /**
     * 数组中的第K个最大元素
     *
     * @param nums
     * @param k
     * @return 示例
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
//    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

    /**
     * 前K个高频元素
     *
     * @param nums
     * @param k
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : set) {
            pq.add(entry);
        }


        for (int i = 0; i < k; i++) {
            list.add(pq.poll().getKey());
        }

        return list;
    }

    /**
     * 基本计算器 II
     *
     * @param s
     * @return 示例
     * 输入: "3+2*2"
     * 输出: 7
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c >= '0') {
                num = num*10+c-'0';
            }
            if (c != ' ' && c < '0' || i == s.length()-1) {
                switch (op){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                op = c;
            }
        }
        int result = 0;
        while (!stack.empty()){
            result += stack.pop();
        }
        return result;
    }


}
