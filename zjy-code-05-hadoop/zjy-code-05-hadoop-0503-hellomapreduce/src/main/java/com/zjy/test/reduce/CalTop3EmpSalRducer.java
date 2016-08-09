package com.zjy.test.reduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/9.
 */
public class CalTop3EmpSalRducer extends Reducer<IntWritable, Text, Text, LongWritable> {
    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        String empName;
        String firstName = "";
        String secondName = "";
        String thirdName = "";

        long empSalary;
        long firstSalary = 0;
        long secondSalary = 0;
        long thirdSalary = 0;

        for (Text value : values) {
            String[] kv = value.toString().split(",");
            empName = kv[0];
            empSalary = Long.parseLong(kv[1]);

            if (empSalary > firstSalary) {
                thirdName = secondName;
                thirdSalary = secondSalary;

                secondName = firstName;
                secondSalary = firstSalary;

                firstName = empName;
                firstSalary = empSalary;

            } else if (empSalary > secondSalary) {
                thirdName = secondName;
                thirdSalary = secondSalary;

                secondName = empName;
                secondSalary = empSalary;
            } else if (empSalary > thirdSalary) {
                thirdName = empName;
                thirdSalary = empSalary;
            }


        }
        context.write(new Text(firstName),new LongWritable(firstSalary));
        context.write(new Text(secondName),new LongWritable(secondSalary));
        context.write(new Text(thirdName),new LongWritable(thirdSalary));
    }
}
