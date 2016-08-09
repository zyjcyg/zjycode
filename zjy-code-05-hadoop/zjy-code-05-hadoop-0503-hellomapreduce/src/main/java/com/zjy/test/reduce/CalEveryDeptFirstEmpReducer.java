package com.zjy.test.reduce;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zjy on 2016/8/6.
 */
public class CalEveryDeptFirstEmpReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        String empName;
        String empEnterDate;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM 月-yy");
        Date earliestDate = new Date();
        String earliestEmp = null;

        for (Text value : values) {
            String[] info = value.toString().split(",");
            empName = info[0];
            empEnterDate = info[1].trim();

            try {
                Date parse = simpleDateFormat.parse(empEnterDate);
                if (parse.compareTo(earliestDate) < 0) {
                    earliestDate = parse;
                    earliestEmp = empName;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        context.write(key,new Text("The earliest emp of dept:" + earliestEmp + ",Enter date:" + new SimpleDateFormat("yyyy-MM-dd").format(earliestDate)));
    }

    public static void main(String[] args) throws ParseException {
        String txt = "7369,SMITH,CLERK,7902,17-12 月-80,800,,20";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM 月-yy");
        String trim = txt.split(",")[4].trim();
        Date parse = simpleDateFormat.parse(trim);
        System.out.println(parse.toString());
    }
}
