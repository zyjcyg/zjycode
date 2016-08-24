package com.zjy.handler;

import com.google.protobuf.GeneratedMessage;
import com.sdyc.ndmp.protobuf.dtd.AdMedia;
import com.zjy.transformer.SparkObjectTransformer;
import kafka.common.TopicAndPartition;
import kafka.serializer.DefaultDecoder;
import kafka.serializer.StringDecoder;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjy on 2016/8/23.
 */
public class KafkaHandler extends StreamingHandler {


    private static KafkaHandler kafkaHandler = null;

    private KafkaHandler() {

    }

    public static KafkaHandler getInstance() {
        if (kafkaHandler == null) {
            kafkaHandler = new KafkaHandler();
        }
        return kafkaHandler;
    }


    public void checkParamMap(Map<String, Object> params) throws Exception {
        if (params.size() != 2) {
            throw new Exception("参数个数不正确");
        }

        if (!params.containsKey("context") ||  !params.containsKey("kafkaParams")) {
            throw new Exception("必填参数不能为空");
        }

        if (!(params.get("context") instanceof JavaStreamingContext)) {
            throw new Exception("context参数类型不是" + JavaStreamingContext.class.getName());
        }

        if (!(params.get("kafkaParams") instanceof Map)) {
            throw new Exception("kafkaParams参数类型不是" + Map.class.getName());
        }

    }

    @Override
    public JavaInputDStream process(Map<String, Object> params) throws Exception {

        checkParamMap(params);
        Map<TopicAndPartition, Long> fromOffsets = new HashMap<TopicAndPartition, Long>();

        JavaInputDStream<GeneratedMessage> directStream = KafkaUtils.createDirectStream(
                (JavaStreamingContext) params.get("context"),
                String.class,
                byte[].class,
                StringDecoder.class,
                DefaultDecoder.class,
                GeneratedMessage.class,
                (Map<String, String>) params.get("kafkaParams"),
                fromOffsets, new SparkObjectTransformer());


        return directStream;
    }
}
