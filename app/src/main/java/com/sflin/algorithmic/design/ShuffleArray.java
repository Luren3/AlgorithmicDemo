package com.sflin.algorithmic.design;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by MagicFrost
 *
 * 初级设计问题算法
 *
 * 题目：打乱数组
 *
 * 说明：打乱一个没有重复元素的数组。
 * 示例
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class ShuffleArray {

    private int[] nums,originNums;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        originNums = Arrays.copyOf(nums, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i=nums.length;i >0;i--){
            int rondom = new Random().nextInt(i);
            int temp = nums[rondom];
            nums[rondom] = nums[i - 1];
            nums[i - 1] = temp;
        }
        return nums;
    }
}
