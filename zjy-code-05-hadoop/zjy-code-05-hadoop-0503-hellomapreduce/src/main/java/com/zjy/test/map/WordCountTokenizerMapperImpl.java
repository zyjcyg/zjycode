package com.zjy.test.map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by zjy on 2016/8/3.
 */
public class WordCountTokenizerMapperImpl implements Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable ONE = new IntWritable(1);
    private Text word = new Text();
    public void map(Object key, Text value, OutputCollector<Text, IntWritable> context, Reporter reporter) throws IOException {

        StringTokenizer itr = new StringTokenizer(value.toString());
        while (itr.hasMoreElements()) {
            word.set(itr.nextToken());
            context.collect(word, ONE);
            reporter.progress();
        }
    }

    public void close() throws IOException {

    }

    public void configure(JobConf job) {

    }
}
