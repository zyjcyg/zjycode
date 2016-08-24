package com.zjy.handler;

import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.flume.FlumeUtils;
import org.apache.spark.streaming.flume.SparkFlumeEvent;

import java.util.Map;

/**
 * Created by zjy on 2016/8/23.
 */
public class FlumeHandler extends StreamingHandler {

    private static FlumeHandler flumeHandler = null;

    private FlumeHandler() {

    }

    public static FlumeHandler getInstance() {
        if (flumeHandler == null) {
            flumeHandler = new FlumeHandler();
        }
        return flumeHandler;
    }


    public void checkParamMap(Map<String, Object> params) throws Exception {
        if (params.size() != 3) {
            throw new Exception("参数个数不正确");
        }

        if (!params.containsKey("context") || !params.containsKey("host")
                || !params.containsKey("port")) {
            throw new Exception("必填参数不能为空");
        }

        if (!(params.get("context") instanceof JavaStreamingContext)) {
            throw new Exception("context参数类型不是" + JavaStreamingContext.class.getName());
        }

        if (!(params.get("host") instanceof String)) {
            throw new Exception("host参数类型不是" + String.class.getName());
        }

        if (!(params.get("port") instanceof String)) {
            throw new Exception("port参数类型不是" + Integer.class.getName());
        }

    }

    @Override
    public JavaInputDStream process(Map<String, Object> params) throws Exception {
        checkParamMap(params);

        JavaInputDStream<SparkFlumeEvent> stream = FlumeUtils.createStream((JavaStreamingContext) params.get("context"), (String) params.get("host"), (Integer) params.get("port"));

        return stream;
    }
}
