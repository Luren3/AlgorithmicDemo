package com.sflin.algorithmic.hash;

/**
 * Created by MagicFrost
 *
 * 简单哈希与映射算法
 */
public class EasyHashUtils {

    /**
     * Excel表列序号
     *
     * @param s
     * @return
     * 示例
     * 输入: "A"
     * 输出: 1
     */
    public static int titleToNumber(String s) {
        int result = 0,n = 1;
        for (int i = s.length() - 1;i >= 0;i--){
            char c = s.charAt(i);
            result += (c - 64) * n;
            n *=26;
        }
        return result;
    }

}
