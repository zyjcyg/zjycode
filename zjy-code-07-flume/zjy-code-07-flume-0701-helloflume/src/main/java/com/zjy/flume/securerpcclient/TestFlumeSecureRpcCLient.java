package com.zjy.flume.securerpcclient;

import org.apache.flume.api.RpcClientConfigurationConstants;

import java.util.Properties;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/14
 * Time: 10:12
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class TestFlumeSecureRpcCLient {

    public static void main(String[] args) {

        SecureRpcClientFacade clientFacade = new SecureRpcClientFacade();
        Properties props = new Properties();
        props.setProperty(RpcClientConfigurationConstants.CONFIG_CLIENT_TYPE, "thrift");
        props.setProperty("hosts", "h1");
        props.setProperty("hosts.h1", "192.168.1.237"+":"+ String.valueOf(4141));

        // Initialize client with the kerberos authentication related properties
        props.setProperty("kerberos", "true");
        props.setProperty("client-principal", "flumeclient/client.example.org@EXAMPLE.ORG");
        props.setProperty("client-keytab", "/tmp/flumeclient.keytab");
        props.setProperty("server-principal", "flume/server.example.org@EXAMPLE.ORG");
        clientFacade.init(props);
        String sampleData = "Hello Flume!";
        for (int i = 0; i < 10; i++) {
            clientFacade.sendDataToFlume(sampleData);
        }
        clientFacade.cleanUp();

    }
}
