package com.leetcode.window;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.functions.co.CoProcessFunction;
import org.apache.flink.util.Collector;

/**
 * @Author: shiwei10
 * @Date: 2024/10/16 19:37
 */
public class ConnectJoin {
    public static void main(String[] args) {
        DataStream<Tuple2<Integer, Integer>> orderStream = null;
        DataStream<String> orderDetailStream = null;
        DataStream<Tuple2<Integer, Integer>> stream1 = null;
        DataStream<Tuple2<Integer, Integer>> stream2 = null;
        DataStream<Tuple2<Integer, Integer>> stream3 = null;

        // 双流join，双流类型不必一致
        orderStream.connect(orderDetailStream)
                .keyBy("orderId", "orderId")
                .process(new CoProcessFunction<Tuple2<Integer, Integer>, String, Object>() {
                    @Override
                    public void processElement1(Tuple2<Integer, Integer> t1, Context context, Collector<Object> collector) throws Exception {

                    }

                    @Override
                    public void processElement2(String s, Context context, Collector<Object> collector) throws Exception {

                    }
                });

        // 多流联合，各个流的数据类型要保持一致
        stream1
                .union(stream2, stream3)
                .keyBy("orderId")
                .process(new ProcessFunction<Tuple2<Integer, Integer>,
                        Object>() {
                    @Override
                    public void processElement(Tuple2<Integer, Integer> t1, Context context, Collector<Object> collector) throws Exception {

                    }
                });
    }
}
