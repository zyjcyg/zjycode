package com.zjy.handler;


import org.apache.spark.streaming.api.java.JavaInputDStream;

import java.util.Map;

/**
 * Created by zjy on 2016/8/23.
 */
public abstract class StreamingHandler {

    public abstract JavaInputDStream process(Map<String, Object> params) throws Exception;

}
