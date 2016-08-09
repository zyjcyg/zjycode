package com.zjy.flume.properties;

import org.apache.flume.Event;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/15
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class  MyRpcClientFacade {
    private RpcClient client;

    Properties props = new Properties();

    private String location = "flume1.properties";

    public void init() {

        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(location));
            this.client = RpcClientFactory.getInstance(props);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendDataToFlume(String data) {
        try {
            final Event event = EventBuilder.withBody(data.getBytes(Charset.forName("UTF-8")));
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Hello", "word");
            headers.put("timestamp", System.currentTimeMillis() + "");
            event.setHeaders(headers);

            client.append(event);
        } catch (Exception e) {
            client.close();
            client = null;
            client = RpcClientFactory.getInstance(props);
        }
    }

    public void cleanUp() {
        client.close();
    }

}