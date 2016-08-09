package com.zjy.test.reduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/6.
 */
public class CalCitySumSalaryReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        long citySumSalary = 0;
        for (Text value : values) {
            citySumSalary += Long.parseLong(value.toString());
        }
        context.write(key, new Text(String.valueOf(citySumSalary)));
    }
}
