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
public class CalCitySumSalaryMapper extends Mapper<LongWritable, Text, Text, Text> {

    private Map<String,String> deptCityInfo;
    private String[] kv;
    @Override
    protected void setup(Context context) throws IOException, InterruptedException {


        deptCityInfo = MRJobUtils.cacheCityInfoFromSmallFile(context);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        kv = value.toString().split(",");
        if (deptCityInfo.containsKey(kv[7])) {
            if (null != kv[5] && !"".equals(kv[5].toString())) {

                context.write(new Text(deptCityInfo.get(kv[7].trim())), new Text(kv[5].trim()));
            }
        }
    }
}
