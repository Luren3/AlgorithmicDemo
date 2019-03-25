package com.sflin.algorithmic.array;

/**
 * Created by MagicFrost
 *
 * 中等数组算法
 */
public class MediumArrayUtils {

    /**
     * 乘积最大子序列
     *
     * @param nums
     * @return
     *
     * 示例
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i=1;i<nums.length;i++){
            int tem = max;
            max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min = Math.min(Math.min(tem*nums[i],min*nums[i]),nums[i]);
            result = Math.max(max,result);
        }
        return result;
    }
//    public int maxProduct(int[] nums) {
//        int result = nums[0];
//        for (int i=0;i<nums.length;i++){
//            int product = 1;
//            for (int j=i;i<nums.length;j++){
//                product *= nums[i];
//                if (product > result){
//                    result = product;
//                }
//            }
//        }
//        return result;
//    }
}
