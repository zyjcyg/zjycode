package com.zjy.test.reduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zjy on 2016/8/9.
 */
public class CalAnyTwoEmpNodesRducer extends Reducer<IntWritable, Text, NullWritable, Text> {


    List<String> empList = new ArrayList<String>();
    Map<String, String> empManMap = new HashMap<String, String>();

    @Override
    protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        for (Text value : values) {
            String[] split = value.toString().split(",");
            empList.add(split[0].trim());
            empManMap.put(split[0].trim(), split[1].trim());
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        int totalEmpCount = empList.size();
        int distance;
        for (int i = 0; i < totalEmpCount - 1; i++) {
            for (int j = (i + 1); j < totalEmpCount; j++) {
                distance = calculateDistance(i, j);
                String value = empList.get(i) + " and " + empList.get(j) + " = " + distance;
                context.write(NullWritable.get(), new Text(value));
            }
        }
    }

    private int calculateDistance(int i, int j) {
        String empA = empList.get(i);
        String empB = empList.get(j);
        int distance = 0;
        if (empManMap.get(empA).equals(empB) || empManMap.get(empB).equals(empA)) {
            distance = 0;
        } else if (empManMap.get(empA).equals(empManMap.get(empB))) {
            distance = 0;
        } else {
            List<String> empAManList = new ArrayList<String>();
            List<String> empBManList = new ArrayList<String>();

            empAManList.add(empA);
            String current = empA;

            while (false == empManMap.get(current).isEmpty()) {
                current = empManMap.get(current);
                empAManList.add(current);
            }

            empBManList.add(empB);
            current = empB;
            while (false == empManMap.get(current).isEmpty()) {
                current = empManMap.get(current);
                empBManList.add(current);
            }

            int i1 = 0, j1= 0;

            String currManA,currManB;
            boolean found = false;
            for (i1 = 0; i1 < empAManList.size(); i1++) {
                currManA = empAManList.get(i1);
                for (j1 =0; j1<empBManList.size(); j1++) {
                    currManB = empBManList.get(j1);
                    if (currManA.equals(currManB)) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            distance = i1 + j1 - 1;

        }
        return distance;
    }
}
