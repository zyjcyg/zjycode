package com.zjy.test.reduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by zjy on 2016/8/7.
 */
public class CalEmpSalHigherAvgSalReducer extends Reducer<IntWritable, Text, Text, Text> {

    private long sumSalary =0;
    private int empCount = 0;
    private long avSalary = 0;

    private long empSalary = 0;

    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        for (Text value : values) {
            String valueString = value.toString();
            if (0 == key.get()) {
                sumSalary += Long.parseLong(valueString);
                empCount++;
                System.out.println("empCount = " + empCount + ", sumSalary = " + sumSalary);

            } else if (1 == key.get()) {
                if (avSalary == 0) {
                    avSalary = sumSalary / empCount;
                    context.write(new Text("avg salary = "), new Text("" + avSalary));
                    context.write(new Text("Following employees have sal higher than avg:"), new Text(""));
                }
                System.out.println("emp salary = " + value);
                avSalary = sumSalary / empCount;
                String[] split = valueString.split(",");
                empSalary = Long.parseLong(split[1]);

                if (empSalary > avSalary) {
                    context.write(new Text(split[0]), new Text("" + empSalary));
                }
            }
        }


       /* double avgSal = 0;
        if (key.get() == 0) {
            long sumSal = 0;
            int empCount = 0;
            for (Text value : values) {
                sumSal += Long.parseLong(value.toString());
                empCount++;
            }
            avgSal = (sumSal + 0.0)/empCount;
        } else {
            for (Text value : values) {
                String[] empInfo = value.toString().split(",");
                long empSal = Long.parseLong(empInfo[1]);
                if (empSal > avgSal) {
                    context.write(new Text(empInfo[0]), new LongWritable(empSal));
                }
            }
        }*/
    }
}
