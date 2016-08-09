package com.zjy.test.map;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/6.
 */
public class CalEmpSalHigherLeaderSalMapper extends Mapper<LongWritable, Text, Text, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] kv = value.toString().split(",");
        context.write(new Text(kv[0].toString()), new Text("M," + kv[5]));

        if (null != kv[3] && !"".equals(kv[3].toString())) {
            context.write(new Text(kv[3].toString()), new Text("E," + kv[1] + "," + kv[5]));
        }
    }

    public static void main(String[] args) {

    }
}
