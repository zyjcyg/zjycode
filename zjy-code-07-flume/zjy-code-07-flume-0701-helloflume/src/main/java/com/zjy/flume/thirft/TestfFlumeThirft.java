package com.zjy.flume.thirft;

import com.zjy.flume.utils.UUIDGenerator;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/14
 * Time: 9:47
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class TestfFlumeThirft {
    public static void main(String[] args) {

        ThirftRpcClientFacade thirftRpcClientFacade = new ThirftRpcClientFacade();
        thirftRpcClientFacade.init("192.168.1.236", 4141);
//        String sampleData = "11.52.10.49 - - [17/Sep/2015:11:35:21 +0800] \"GET /webapp HTTP/1.1\" 302 - \"-\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36\"";
        for (int i = 0; i < 10; i++) {
            thirftRpcClientFacade.sendData2Flume(UUIDGenerator.getUUID() + "##" + 234 + "##" + UUIDGenerator.getUUID());
        }
        thirftRpcClientFacade.cleanUp();
    }
}
