package com.zjy.test.map;

import com.zjy.test.utils.MRJobUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by zjy on 2016/8/6.
 */
public class CalEveryDeptFirstEmpMapper extends Mapper<LongWritable, Text, Text, Text> {

    private Map<String,String> deptMap;
    private String[] kv;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        deptMap = MRJobUtils.cacheDeptInfoFromSmallFile(context);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        kv = value.toString().split(",");

        if (deptMap.containsKey(kv[7])) {
            if (null != kv[4] && !"".equals(kv[4].toString())) {
                context.write(new Text(deptMap.get(kv[7].trim())),new Text(kv[1].trim()+"," + kv[4].trim()));
            }
        }
    }
}
