package com.sflin.algorithmic.stack;

import java.util.ArrayDeque;

/**
 * Created by MagicFrost
 *
 * 困难堆、栈和队列算法
 */
public class HardStackUtils {

    /**
     * 滑动窗口最大值
     *
     * @param nums
     * @param k
     * @return
     * 示例
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     */
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if (n==0 || k==0) return new int[]{};
//        int[] result = new int[n-k+1];
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        int index = 0;
//        for(int i=0;i<n;i++){
//            queue.offer(nums[i]);
//            if (queue.size() == k){
//                result[index] = queue.peek();
//                queue.remove(nums[index]);
//                if (index == n - k) break;
//                index++;
//            }
//        }
//        return result;
//    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n==0 || k==0) return new int[]{};
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n-k+1];
        for(int i=0;i<n;i++){
            if (!deque.isEmpty() && deque.peekFirst() == i - k){
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.offerLast(i);
            if (i+1 >= k){
                result[i+1 - k] = nums[deque.peek()];
            }
        }
        return result;
    }
}
