package com.sflin.algorithmic.sort_and_serarch;

import java.util.Arrays;

/**
 * Created by MagicFrost
 *
 * 初级排序和搜索
 */
public class EasySortAndSearchUtils {

    /**
     * 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     *
     * 示例
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newArr = new int[m+n];
        for (int i = 0; i < m;i++){
            newArr[i] = nums1[i];
        }
        for (int i = 0; i < n;i++){
            newArr[m+i] = nums2[i];
        }
        Arrays.sort(newArr);
        for (int i = 0; i < newArr.length;i++){
            nums1[i] = newArr[i];
        }
    }
}
