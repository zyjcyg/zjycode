package com.zjy.test.map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/9.
 */
public class CalSortByEmpIncomeMapper extends Mapper<LongWritable, Text, IntWritable, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] split = value.toString().split(",");
        int empIncome = "".equals(split[6]) ? Integer.parseInt(split[5]) :
                Integer.parseInt(split[5]) + Integer.parseInt(split[6]);
        context.write(new IntWritable(empIncome), new Text(split[1].trim()));
    }
}
