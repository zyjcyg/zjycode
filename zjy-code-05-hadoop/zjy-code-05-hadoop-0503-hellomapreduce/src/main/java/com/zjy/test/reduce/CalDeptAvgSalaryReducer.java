package com.zjy.test.reduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/6.
 */
public class CalDeptAvgSalaryReducer extends Reducer<Text, Text, Text, Text> {


    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        long sumDeptSalary = 0;
        int deptEmpNum = 0;

        for (Text value : values) {
            sumDeptSalary += Long.parseLong(value.toString());
            deptEmpNum++;
        }

        double avgDeptSal = (sumDeptSalary + 0.0) / deptEmpNum;
        context.write(key,new Text(String.valueOf(avgDeptSal)));
    }
}
