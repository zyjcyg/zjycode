package com.zjy.p2;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjyll
 * Date: 2016/1/27
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class Mother {

    public void narrate(IReader reader) {
        System.out.println("妈妈开始讲故事......");
        System.out.println(reader.getContent());

    }
}