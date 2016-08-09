package com.zjy.test.serializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.zjy.test.entry.AccessLog;
import com.zjy.test.parser.AccessLogParser;
import com.zjy.test.utils.UUIDGenerator;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.conf.ComponentConfiguration;
import org.apache.flume.sink.hbase.HbaseEventSerializer;
import org.apache.hadoop.hbase.client.Increment;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Row;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/29
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class AsyncHbaseLogEventSerializer implements HbaseEventSerializer {


//列族

    private byte[] colFam = "cf".getBytes();


    private Event currentEvent;

    public void initialize(Event event, byte[] colFam) {

        this.currentEvent = event;

        this.colFam = colFam;

    }

    public void configure(Context context) {
    }

    public void configure(ComponentConfiguration conf) {

    }

    public List<Row> getActions() {

        // Split the event body and get the values for the columns

        String eventStr = new String(currentEvent.getBody());

        AccessLog cols = AccessLogParser.parse(eventStr);

        String req = cols.getRequest();

        String reqPath = req.split(" ")[1];

        int pos = reqPath.indexOf("?");

        if (pos > 0) {

            reqPath = reqPath.substring(0, pos);

        }

        if (reqPath.length() > 1 && reqPath.trim().endsWith("/")) {

            reqPath = reqPath.substring(0, reqPath.length() - 1);

        }

        String req_ts_str = cols.getDateTime();

        Long currTime = System.currentTimeMillis();

        String currTimeStr = null;

        if (req_ts_str != null && !req_ts_str.equals("")) {

            SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.US);

            SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            try {

                currTimeStr = df2.format(df.parse(req_ts_str));

                currTime = df.parse(req_ts_str).getTime();

            } catch (ParseException e) {

                System.out.println("parse req time error,using system.current time.");

            }

        }

        long revTs = Long.MAX_VALUE - currTime;

        //行健根据自己需求设计

        byte[] currentRowKey = (UUIDGenerator.getUUID() + Long.toString(revTs) + reqPath).getBytes();

        List<Row> puts = new ArrayList<Row>();

        Put putReq = new Put(currentRowKey);


        //增加列

        putReq.add(colFam, "clientip".getBytes(), Bytes.toBytes(cols.getClientIp()));

        putReq.add(colFam, "clientindentity".getBytes(), Bytes.toBytes(cols.getClientIndentity()));

        putReq.add(colFam, "remoteuser".getBytes(), Bytes.toBytes(cols.getRemoteUser()));

        putReq.add(colFam, "httpstatuscode".getBytes(), Bytes.toBytes(cols.getHttpStatusCode()));

        putReq.add(colFam, "bytessent".getBytes(), Bytes.toBytes(cols.getBytesSent()));

        putReq.add(colFam, "request".getBytes(), Bytes.toBytes(cols.getRequest()));

        putReq.add(colFam, "referer".getBytes(), Bytes.toBytes(cols.getReferer()));

        putReq.add(colFam, "datetime".getBytes(), Bytes.toBytes(currTimeStr));

        putReq.add(colFam, "useragent".getBytes(), Bytes.toBytes(cols.getUserAgent()));

        puts.add(putReq);

        return puts;

    }

    public List<Increment> getIncrements() {

        List<Increment> incs = new ArrayList<Increment>();


        return incs;

    }


    public void close() {
        colFam = null;
        currentEvent = null;
    }


}