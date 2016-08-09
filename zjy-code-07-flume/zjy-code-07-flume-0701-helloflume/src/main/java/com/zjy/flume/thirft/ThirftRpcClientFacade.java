package com.zjy.flume.thirft;

import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

import java.nio.charset.Charset;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/14
 * Time: 9:49
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class ThirftRpcClientFacade {

    private RpcClient rpcClient;
    private String hostName;
    private int hostPort;


    public void init(String hostName, int hostPort) {
        this.hostName = hostName;
        this.hostPort = hostPort;
        this.rpcClient = RpcClientFactory.getDefaultInstance(hostName, hostPort);
    }

    public void sendData2Flume(String data) {
        final Event event = EventBuilder.withBody(data, Charset.forName("UTF-8"));
        try {
            rpcClient.append(event);
        } catch (EventDeliveryException e) {
            e.printStackTrace();
        } finally {
            rpcClient.close();
            rpcClient = null;
            rpcClient = RpcClientFactory.getDefaultInstance(hostName, hostPort);
        }

    }

    public void cleanUp() {
        rpcClient.close();
    }

}
