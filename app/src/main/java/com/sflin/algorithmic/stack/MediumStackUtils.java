package com.sflin.algorithmic.stack;

import java.util.PriorityQueue;

/**
 * Created by MagicFrost
 *
 * 中等堆、栈和队列算法
 */
public class MediumStackUtils {

    /**
     * 数组中的第K个最大元素
     *
     * @param nums
     * @param k
     * @return
     *
     * 示例
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num:nums){
            queue.add(num);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
//    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

}
