package com.sflin.algorithmic.sort_and_serarch;

import java.util.Arrays;

/**
 * Created by MagicFrost
 * <p>
 * 初级排序和搜索
 */
public class EasySortAndSearchUtils {

    /**
     * 合并两个有序数组
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n     示例
     *              输入:
     *              nums1 = [1,2,3,0,0,0], m = 3
     *              nums2 = [2,5,6],       n = 3
     *              <p>
     *              输出: [1,2,2,3,5,6]
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - nums2.length;
        for (int i = 0; i < nums2.length; i++) {
            nums1[index + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 第一个错误的版本
     *
     * @param n
     * @return 示例
     * 给定 n = 5，并且 version = 4 是第一个错误的版本。
     * <p>
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * <p>
     * 所以，4 是第一个错误的版本。
     */
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public static int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private static boolean isBadVersion(int version) {
        return false;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin)
            return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        //pivot: 标杆位置，counter：小于pivot的元素的个数
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;
        return counter;
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left)
            return;
        int mid = (left + right) >> 1;// (left + right) / 2
        mergeSort(array, left, mid);
        mergeSort(array, mid, right);
        merge(array, left, mid, right);//System.arraycopy(a,start1,b,start2,length);

    }
    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }
        while (i <= mid) {
            array[k++] = array[i++];
        }
        while (j <= right) {
            array[k++] = array[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            array[left + p] = temp[p];
        }

    }
}
