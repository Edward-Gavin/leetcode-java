package com.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shiwei10
 * @create: 2024-09-21 23:47
 */
public class MinStack {

    private List<Integer> cap;
    private List<Integer> min;

    public MinStack() {
        cap = new ArrayList<>();
        min = new ArrayList<>();
    }

    public void push(int val) {
        cap.add(val);

        if (min.isEmpty()) {
            min.add(val);
        } else {
            min.add(Math.min(min.get(min.size() - 1), val));
        }
    }

    public void pop() {
        cap.remove(cap.size() - 1);
        min.remove(min.size() - 1);
    }

    public int top() {
        return cap.get(cap.size() - 1);
    }

    public int getMin() {
        return min.get(min.size() - 1);
    }

}
