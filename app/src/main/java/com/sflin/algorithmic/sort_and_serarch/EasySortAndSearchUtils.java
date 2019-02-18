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
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
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

    /**
     * 第一个错误的版本
     *
     * @param n
     * @return
     *
     * 示例
     * 给定 n = 5，并且 version = 4 是第一个错误的版本。
     *
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     *
     * 所以，4 是第一个错误的版本。
     */
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public static int firstBadVersion(int n) {
        int low = 1, high = n;
        while(low < high){
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    private static boolean isBadVersion(int version){
        return false;
    }
}
