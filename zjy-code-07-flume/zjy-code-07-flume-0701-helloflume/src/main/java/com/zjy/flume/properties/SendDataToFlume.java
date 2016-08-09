package com.zjy.flume.properties;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zhangjiyong
 * Date: 2016/5/17
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class SendDataToFlume {


    public static void main(String[] args) {

        MyRpcClientFacade client = new MyRpcClientFacade();
        client.init();
        String line = "There are moments in life when you miss someone so much that you just want to pick them from your dreams and hug them for real";
        final String[] words = line.split(" ");

        for (int i = 0; i < 10000; i++) {
            client.sendDataToFlume(words[(int) (Math.random() * words.length)]);
        }
        client.cleanUp();
    }
}


