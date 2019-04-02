package com.sflin.algorithmic.stack;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by MagicFrost
 * <p>
 * 数据流的中位数
 * <p>
 * 示例
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class MedianFinder {

    private int count = 0;
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    /**
     * initialize your data structure here.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (count % 2 == 0) {
            max.offer(num);
            int temp = max.poll();
            min.offer(temp);
        } else {
            min.offer(num);
            int temp = min.poll();
            max.offer(temp);
        }
        count++;
    }

    public double findMedian() {
        if (count % 2 == 0) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return min.peek();
        }
    }

//    private List<Integer> list;
//
//    /** initialize your data structure here. */
//    public MedianFinder() {
//        list = new ArrayList<>();
//    }
//
//    public void addNum(int num) {
//        list.add(num);
//    }
//
//    public double findMedian() {
//        double median = 0;
//        int index = 0;
//        int n = list.size();
//        Integer[] arr = new Integer[n];
//        arr = list.toArray(arr);
//        Arrays.sort(arr);
//        if (n%2 == 0){
//            index = (n / 2) - 1;
//            median = (arr[index] + arr[index+1])/2.0;
//        }else {
//            index = n / 2;
//            median = arr[index];
//        }
//        return median;
//    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
