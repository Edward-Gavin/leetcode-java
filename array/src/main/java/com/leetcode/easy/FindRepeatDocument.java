package com.leetcode.easy;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: shiwei10
 * @Date: 2024/10/9 11:37
 */
public class FindRepeatDocument {
    public int findRepeatDocument(int[] documents) {

        Set<Integer> set = new TreeSet();

        for (int document : documents) {
            if (set.contains(document)) {
                return document;
            } else {
                set.add(document);
            }
        }
        return -1;
    }
}
