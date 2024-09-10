package com.leetcode.string;

/**
 * https://leetcode-cn.com/problems/implement-strstr/solution/sundaysuan-fa-shi-xian-by-cheungq-6-ikp7/
 *
 * @Author: shiwei10
 * @Date: 2021/12/6 7:58 pm
 */
public class SundayAlgorithm {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int[] position = new int[256];
        for (int i = 0; i < n; i++) {
            position[needle.charAt(i)] = i;
        }

        for (int i = 0; i + n < m; i += (n - position[haystack.charAt(i + n)])) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) == needle.charAt(j)) {
                    continue;
                }
                flag = false;
                break;
            }
            if (flag){
                return i;
            }
            if (i + n >= m) {
                break;
            }
        }
        return -1;
    }
}
