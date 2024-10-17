package com.leetcode.window;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.functions.co.ProcessJoinFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * @Author: shiwei10
 * @Date: 2024/10/16 19:31
 */
public class IntervalWindow {
    public static void main(String[] args) {

        DataStream<Tuple2<Integer, Integer>> orderStream = null;
        DataStream<Tuple2<Integer, Integer>> orderDetailStream = null;

        orderStream
                .keyBy(r -> r.f0)// 调用intervalJoin关联
                .intervalJoin(orderDetailStream.keyBy(r -> r.f0))
                .between(Time.milliseconds(-30), Time.milliseconds(30))
                .process(new ProcessJoinFunction<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>, Object>() {
                    @Override
                    public void processElement(Tuple2<Integer, Integer> t1, Tuple2<Integer, Integer> t2,
                                               Context context, Collector<Object> collector) throws Exception {

                        collector.collect(t1);
                    }
                })
                .setParallelism(10)
                .print();

    }
}
