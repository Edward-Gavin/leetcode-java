package com.leetcode.transaction;

import org.apache.flink.api.common.typeutils.TypeSerializer;
import org.apache.flink.streaming.api.functions.sink.TwoPhaseCommitSinkFunction;

/**
 * @Author: shiwei10
 * @Date: 2024/10/17 11:42
 */
public class Transaction extends TwoPhaseCommitSinkFunction {

    public Transaction(TypeSerializer transactionSerializer, TypeSerializer contextSerializer) {
        super(transactionSerializer, contextSerializer);
    }

    public static void main(String[] args) {

    }

    @Override
    protected void invoke(Object o, Object o2, Context context) throws Exception {

    }

    @Override
    protected Object beginTransaction() throws Exception {
        return null;
    }

    @Override
    protected void preCommit(Object o) throws Exception {

    }

    @Override
    protected void commit(Object o) {

    }

    @Override
    protected void abort(Object o) {

    }
}
