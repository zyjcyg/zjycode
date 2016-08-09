package com.zjy.test.map;

import com.zjy.test.utils.MRJobUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by zjy on 2016/8/9.
 */
public class CalEmpInfoStartWithJMapper extends Mapper<LongWritable, Text, Text, Text> {

    private Map<String,String> deptMap;
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {

        deptMap = MRJobUtils.cacheDeptInfoFromSmallFile(context);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String[] kv = value.toString().split(",");
        if (kv[1] != null && !"".equals(kv[1].trim()) && kv[1].trim().startsWith("J")) {
            context.write(new Text(kv[1].trim()),new Text(deptMap.get(kv[7].trim())));
        }
    }
}
