package com.zjy.test.reduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/6.
 */
public class CalDeptSumSalaryReducer extends Reducer<Text, Text, Text, LongWritable> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        int sumSalary = 0;
        for (Text text : values) {
            sumSalary += Long.parseLong(text.toString());
        }

        context.write(key, new LongWritable(sumSalary));
    }
}
