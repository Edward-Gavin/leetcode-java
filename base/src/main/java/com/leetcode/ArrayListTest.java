package com.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shiwei10
 * @Date: 2024/4/30 17:36
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        for (String str : strList) {
            if ("b".equals(str)) {
                strList.remove(str);
            }
        }
    }
}
