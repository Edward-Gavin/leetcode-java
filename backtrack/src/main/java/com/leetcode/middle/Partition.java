package com.leetcode.middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/4/29 16:18
 * @Description: 131. 分割回文串
 */
public class Partition {
    // 结果集
    List<List<String>> result = new ArrayList<>();

    // 寻找的路径
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return result;
    }

    public void backTrack(String str, int startIndex) {

        // 符合要求的结果加入到结果集
        if (startIndex >= str.length()) {
            result.add(new ArrayList<>(path));
            return ;
        }

        for (int i = startIndex; i < str.length(); i++) {
            String substring = str.substring(startIndex, i + 1);
            if (isPalindrome(substring)) {
                path.add(substring);
            } else {
                continue;
            }
            backTrack(str, i + 1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String s) {
        int right = s.length()-1;
        int mid = s.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Partition().partition("abbab"));
    }
}
