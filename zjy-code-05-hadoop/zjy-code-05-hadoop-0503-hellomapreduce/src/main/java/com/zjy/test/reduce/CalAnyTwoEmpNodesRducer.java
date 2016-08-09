package com.zjy.test.reduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/9.
 */
public class CalAnyTwoEmpNodesRducer extends Reducer<IntWritable, Text, NullWritable, Text> {
    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
    }
}
