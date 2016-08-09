package com.zjy.test.reduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjy on 2016/8/6.
 */
public class CalEmpSalHigherLeaderSalReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        String empName;
        long empSalary = 0;
        HashMap<String, Long> empMap = new HashMap<String, Long>();
        long mgrSalary = 0;

        for (Text value : values) {
            String[] split = value.toString().split(",");
            if (value.toString().startsWith("E")) {
                empName = split[1];
                empSalary = Long.parseLong(split[2]);
                empMap.put(empName, empSalary);
            } else {
                mgrSalary = Long.parseLong(split[1]);
            }
        }

        for (Map.Entry<String, Long> stringLongEntry : empMap.entrySet()) {
            if (stringLongEntry.getValue() > mgrSalary) {
                context.write(new Text(stringLongEntry.getKey()),new Text(String.valueOf(stringLongEntry.getValue())));
            }
        }

    }
}
