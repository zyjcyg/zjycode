package com.zjy.producer;

import kafka.javaapi.producer.Producer;
import kafka.javaapi.producer.ProducerData;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjy
 * Date: 16-9-28
 * Time: 下午3:33
 * PC：ubuntu'IDEA with mine <br>
 * </pre>
 *
 * @author zjy.
 */
public class KafkaProducer {
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("zk.connect", "192.168.1.101:2181");
        props.put("serializer.class", "kafka.serializer.StringEncoder");

        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<String, String>(config);
        ProducerData<String, String> data = new ProducerData("liu-test", "test-message2");
        producer.send(data);
        producer.close();
    }
}
