package com.zjy.transformer;


import com.google.protobuf.GeneratedMessage;
import com.sdyc.ndmp.protobuf.dtd.AdMedia;
import com.sdyc.ndmp.protobuf.serializer.ProtobufSerializer;
import com.sdyc.ndmp.protobuf.serializer.Serializer;
import kafka.common.TopicAndPartition;
import kafka.message.MessageAndMetadata;
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
public class SparkObjectTransformer<T extends GeneratedMessage> implements
        Function<MessageAndMetadata<String, byte[]>, GeneratedMessage> {


    public GeneratedMessage call(MessageAndMetadata<String, byte[]> v1) throws Exception {
        Serializer<GeneratedMessage> serializer = new ProtobufSerializer();
        return  serializer.deserialize(v1.message());
    }

}
