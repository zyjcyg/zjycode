package com.zjy.flume.securerpcclient;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.SecureRpcClientFactory;
import org.apache.flume.event.EventBuilder;

import java.nio.charset.Charset;
import java.util.Properties;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/14
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class SecureRpcClientFacade {

    private RpcClient rpcClient;
    private Properties properties;

    public void init(Properties properties) {
        this.properties = properties;
        rpcClient = SecureRpcClientFactory.getThriftInstance(properties);
    }


    public void sendDataToFlume(String data) {
        Event event = EventBuilder.withBody(data, Charset.forName("UTF-8"));
        try {
            rpcClient.append(event);
        } catch (EventDeliveryException e) {
            rpcClient.close();
            rpcClient = null;
            rpcClient = SecureRpcClientFactory.getThriftInstance(properties);
        }
    }

    public void cleanUp() {
        rpcClient.close();
    }
}
