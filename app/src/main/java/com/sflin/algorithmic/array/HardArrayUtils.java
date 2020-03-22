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

    /**
     * 42. 接雨水
     *
     * @param height
     * @return
     *
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 示例
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     *
     */
//    public int trap(int[] height) {
//        int left = 0, right = height.length - 1;
//        int lMax = 0, rMax = 0;
//        int res = 0;
//
//        while (left < right) {
//            if (height[left] < height[right]) {
//                if (lMax > height[left]) {
//                    res += lMax - height[left];
//                }
//                else {
//                    lMax = height[left];
//                }
//                left++;
//            }
//            else {
//                if (rMax > height[right]) {
//                    res += rMax -height[right];
//                }
//                else {
//                    rMax = height[right];
//                }
//                right--;
//            }
//        }
//        return res;
//    }
    public static int trap(int[] height) {

        if (height.length < 3){
            return 0;
        }

        int result = 0;

        //最大值下标
        int index = maxIndex(height);

        //计算左边雨水量
        result += rainWaterValue(height,index + 1);

        int[] newArr = new int[height.length - index];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = height[height.length - i -1];
        }

        //计算右边雨水量
        result += rainWaterValue(newArr,newArr.length);

        return result;
    }

    private static int maxIndex(int[] height){
        int max = 0,index = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] > max){
                max = height[i];
                index = i;
            }
        }
        return index;
    }

    private static int rainWaterValue(int[] arr,int index){
        int left = 0;

        boolean isHasPeak = false;

        int result = 0;

        for (int i = 0; i < index; i++) {

            if (isHasPeak){
                if (arr[i] >= arr[left]){
                    result += calculate(arr,left,i);
                    left = i;
                }
            }else {
                if (arr[i] >= arr[left]){
                    left = i;
                }else {
                    isHasPeak = true;
                }
            }
        }
        return result;
    }

    private static int calculate(int[] height,int left,int right){
        int diff = height[left];
        int result = 0;
        for (int i = left + 1; i < right; i++) {
            result += diff - height[i];
        }
        return result;
    }
}
