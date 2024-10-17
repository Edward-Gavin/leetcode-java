package com.leetcode.window;

import org.apache.flink.api.common.functions.CoGroupFunction;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.functions.co.ProcessJoinFunction;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

/**
 * @Author: shiwei10
 * @Date: 2024/10/16 18:54
 */
public class Window {
    public static void main(String[] args) {
        DataStream<Tuple2<Integer, Integer>> orderStream = null;
        DataStream<Tuple2<Integer, Integer>> orderDetailStream = null;

        orderStream
                .join(orderDetailStream)
                .where(r -> r.f0)
                .equalTo(r -> r.f0)
                .window(TumblingEventTimeWindows.of(Time.seconds(60)))
                .apply(new JoinFunction<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>, Object>() {
                    @Override
                    public Object join(Tuple2<Integer, Integer> first, Tuple2<Integer, Integer> second) throws Exception {
                        return null;
                    }
                })
                .print();


        // 这里看看java算子的写法
        orderDetailStream
                .coGroup(orderStream)
                .where(r -> r.f0).equalTo(r -> r.f0)
                .window(TumblingProcessingTimeWindows.of(Time.seconds(60)))
                .apply(new CoGroupFunction<Tuple2<Integer, Integer>, Tuple2<Integer, Integer>, Object>() {
                    @Override
                    public void coGroup(Iterable<Tuple2<Integer, Integer>> first,
                                        Iterable<Tuple2<Integer, Integer>> second, Collector<Object> out) throws Exception {

                    }
                })
                .print();


        DataStream<Integer> greenStream = null;
        DataStream<Integer> orangeStream = null;

        orangeStream
                .join(greenStream)
                .where(r -> r)
                .equalTo(r -> r)
                .window(EventTimeSessionWindows.withGap(Time.seconds(60)))
                .apply(new JoinFunction<Integer, Integer, Object>() {
                    @Override
                    public Object join(Integer first, Integer second) throws Exception {
                        return null;
                    }
                })
                .print();

        orangeStream
                .coGroup(greenStream)
                .where(r -> r)
                .equalTo(r -> r)
                .window(SlidingProcessingTimeWindows.of(Time.seconds(60), Time.seconds(10)))
                .apply(new CoGroupFunction<Integer, Integer, Object>() {
                    @Override
                    public void coGroup(Iterable<Integer> first, Iterable<Integer> second, Collector<Object> out) throws Exception {

                    }
                }).print();

        orangeStream
                .join(greenStream)
                .where(r -> r)
                .equalTo(r -> r)
                .window(TumblingEventTimeWindows.of(Time.seconds(60)))
                .apply(new JoinFunction<Integer, Integer, Object>() {
                    @Override
                    public Object join(Integer first, Integer second) throws Exception {
                        return null;
                    }
                }).print();
    }
}

