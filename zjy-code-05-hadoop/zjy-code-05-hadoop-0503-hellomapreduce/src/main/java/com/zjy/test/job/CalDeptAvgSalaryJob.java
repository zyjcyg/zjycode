package com.zjy.test.job;

import com.zjy.test.map.CalDeptAvgSalaryMapper;
import com.zjy.test.reduce.CalDeptAvgSalaryReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


/**
 * Created by zjy on 2016/8/6.
 */
public class CalDeptAvgSalaryJob extends Configured implements Tool{

    public int run(String[] args) throws Exception {
        Job job = Job.getInstance(getConf(), "CalDeptAvgSalaryJob");
        job.setJobName("CalDeptAvgSalaryJob");
        job.setJarByClass(CalDeptAvgSalaryJob.class);
        job.setMapperClass(CalDeptAvgSalaryMapper.class);
        job.setReducerClass(CalDeptAvgSalaryReducer.class);

        job.setInputFormatClass(TextInputFormat.class);

        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        String[] otherArgs = new GenericOptionsParser(job.getConfiguration(), args).getRemainingArgs();

        DistributedCache.addCacheFile(new Path(otherArgs[0]).toUri(), job.getConfiguration());

        FileInputFormat.addInputPath(job, new Path(otherArgs[1]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[2]));

        job.waitForCompletion(true);
        return job.isSuccessful() ? 0 : 1;
    }


    public static void main(String[] args) throws Exception {
        int run = ToolRunner.run(new Configuration(), new CalDeptAvgSalaryJob(), args);
        System.exit(run);

    }
}