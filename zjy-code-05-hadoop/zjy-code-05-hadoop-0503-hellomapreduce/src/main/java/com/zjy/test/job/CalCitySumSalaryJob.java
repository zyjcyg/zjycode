package com.zjy.test.job;

import com.zjy.test.map.CalCitySumSalaryMapper;
import com.zjy.test.reduce.CalCitySumSalaryReducer;
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
public class CalCitySumSalaryJob extends Configured implements Tool {
    public int run(String[] args) throws Exception {
        Job job = Job.getInstance(getConf(), "CalCitySumSalaryJob");
        job.setJarByClass(CalCitySumSalaryJob.class);

        job.setMapperClass(CalCitySumSalaryMapper.class);
        job.setReducerClass(CalCitySumSalaryReducer.class);

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
        int run = ToolRunner.run(new Configuration(), new CalCitySumSalaryJob(), args);
        System.exit(run);
    }
}
