package com.zjy.kafka.producer;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by zjy on 2016/8/12.
 */
public class KafkaProducer {


    private  static Producer<String,byte[]> kafkaProducer = null;



    static {
        Properties originalProps = new Properties();

        try {
            originalProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("producer.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ProducerConfig config = new ProducerConfig(originalProps);
        kafkaProducer = new Producer<String, byte[]>(config);
    }

    public static void main(String[] args) {

        int i = 0;

        while (i < 10) {
            sendData("hello kafka " + i++);
        }
    }

    public static void sendData(String data) {

        kafkaProducer.send(new KeyedMessage<String, byte[]>("connector-topic", data.getBytes()));

    }
}
