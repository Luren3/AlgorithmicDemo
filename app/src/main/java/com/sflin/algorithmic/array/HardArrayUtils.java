package com.sflin.algorithmic.array;

/**
 * Created by MagicFrost
 * <p>
 * 困难数组算法
 */
public class HardArrayUtils {

    /**
     * 跳跃游戏 II
     * @param nums
     * @return
     * 示例
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     */
    public static int jump(int[] nums) {

        if (nums.length <= 1){
            return 0;
        }

        return nextStep(nums,1,0);
    }

    private static int nextStep(int[] nums,int step,int index){

        if (step == nums.length - 1){
            return step;
        }

        int num = nums[index];

        if (nums.length - 1 - index > num){
            int max = 0;
            int tmp = index;
            for (int i = 1; i <=num; i++) {
                if (max <= nums[tmp+i] + i){
                    max = nums[tmp+i] + i;
                    index = tmp+i;
                }
            }

            return nextStep(nums,step+1,index);
        }
        return step;
    }
}
