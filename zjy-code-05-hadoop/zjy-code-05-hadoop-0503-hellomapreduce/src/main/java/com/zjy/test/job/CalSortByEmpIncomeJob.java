package com.zjy.test.job;

import com.zjy.test.map.CalSortByEmpIncomeMapper;
import com.zjy.test.utils.DecreaseComparator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * Created by zjy on 2016/8/9.
 */
public class CalSortByEmpIncomeJob extends Configured implements Tool {

    public static void main(String[] args) throws Exception {

        int run = ToolRunner.run(new Configuration(), new CalSortByEmpIncomeJob(), args);
        System.exit(run);
    }

    public int run(String[] args) throws Exception {
        Job job = Job.getInstance(getConf(), "CalSortByEmpIncomeJob");
        job.setJarByClass(CalSortByEmpIncomeJob.class);

        job.setMapperClass(CalSortByEmpIncomeMapper.class);
//        job.setReducerClass(CalSortByEmpIncomeRducer.class);

        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Text.class);

        job.setSortComparatorClass(DecreaseComparator.class);
        String[] otherArgs = new GenericOptionsParser(job.getConfiguration(), args).getRemainingArgs();

        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

        job.waitForCompletion(true);
        return job.isSuccessful() ? 0 : 1;
    }

}
