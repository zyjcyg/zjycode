package com.zjy.factory;

import com.zjy.handler.FlumeHandler;
import com.zjy.handler.KafkaHandler;
import com.zjy.handler.StreamingHandler;
import com.zjy.utils.SparkStreamingConstants;

/**
 * Created by zjy on 2016/8/23.
 */
public class SparkStreamingFactory {


    private static StreamingHandler handler = null;

    private SparkStreamingFactory() {

    }

    public static StreamingHandler getInstance(String type) {

        if (handler == null) {

            if (SparkStreamingConstants.FLUME_INPUT.equalsIgnoreCase(type)) {
                handler = FlumeHandler.getInstance();
            }

            if (SparkStreamingConstants.KAFKA_INPUT.equalsIgnoreCase(type)) {
                handler = KafkaHandler.getInstance();
            }
        }

        return handler;

    }


}
