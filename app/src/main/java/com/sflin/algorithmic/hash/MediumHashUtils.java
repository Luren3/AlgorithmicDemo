package com.sflin.algorithmic.hash;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MagicFrost
 *
 * 中等哈希与映射算法
 */
public class MediumHashUtils {

    /**
     * 四数相加 II
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     * 示例
     * 输入:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     *
     * 输出:
     * 2
     *
     * 解释:
     * 两个元组如下:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0) + 1);
            }
        }
        for (int m=0;m<len;m++){
            for (int n=0;n<len;n++){
                int tmp = -(C[m]+D[n]);
                count += map.getOrDefault(tmp,0);
            }
        }
        return count;
    }
}
