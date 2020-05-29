package com.sflin.algorithmic;

/**
 * Created by huangwei on 2020/4/11.
 */
class Test {

    public static void main(String[] args) {
        String[] arr = "  hello world!  ".trim().split(" ");

        StringBuilder builder = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]).append(" ");
        }
        System.out.println(builder.toString().trim());
    }

    public static String reverseStr(String s, int k) {
        if (s.length() < k)
            return reverseString(s);

        int n = 1;
        int index = n * k;
        StringBuilder builder = new StringBuilder();
        while (index <= s.length()) {
            String str = s.substring(index);
            if (str.length() < k) {
                builder.append(reverseString(str));
            } else {
                int begin = index - k;
                String str2 = s.substring(begin, index);
                builder.append(reverseString(str2));
            }

            n++;
            index += n * k;
        }

        return builder.toString();
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return new String(chars);
    }
}
