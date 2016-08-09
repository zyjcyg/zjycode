package com.zjy.test.map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/9.
 */
public class CalTop3EmpSalMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] kv = value.toString().split(",");

        context.write(new IntWritable(0),new Text(kv[1].trim() + "," + kv[5].trim()));
    }
}
