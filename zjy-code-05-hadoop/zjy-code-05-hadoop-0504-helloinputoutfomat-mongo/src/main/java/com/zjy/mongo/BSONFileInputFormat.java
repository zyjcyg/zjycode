
package com.zjy.mongo;


import com.zjy.mongo.input.BSONFileRecordReader;
import com.zjy.mongo.input.BSONFileSplit;
import com.zjy.mongo.splitter.BSONSplitter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.zjy.mongo.splitter.BSONSplitter.getSplitsFilePath;


public class BSONFileInputFormat extends FileInputFormat {

    private static final Log LOG = LogFactory.getLog(BSONFileInputFormat.class);

    @Override
    public RecordReader createRecordReader(final InputSplit split, final TaskAttemptContext context)
        throws IOException, InterruptedException {

        if (split instanceof BSONFileSplit) {
            // Split was created by BSONSplitter and starts at a whole document.
            return new BSONFileRecordReader();
        }

        // Split was not created by BSONSplitter, and we need to find the
        // first document to begin iterating.
        FileSplit fileSplit = (FileSplit) split;
        BSONSplitter splitter = new BSONSplitter();
        splitter.setConf(context.getConfiguration());
        splitter.setInputPath(fileSplit.getPath());

        return new BSONFileRecordReader(
          splitter.getStartingPositionForSplit(fileSplit));
    }

    public static PathFilter getInputPathFilter(final JobContext context) {
        Configuration conf = context.getConfiguration();
        Class<?> filterClass = conf.getClass("bson.pathfilter.class", null, PathFilter.class);
        return filterClass != null ? (PathFilter) ReflectionUtils.newInstance(filterClass, conf) : null;
    }

    @Override
    public List<FileSplit> getSplits(final JobContext context) throws IOException {
        Configuration config = context.getConfiguration();
        PathFilter pf = getInputPathFilter(context);
        BSONSplitter splitter = new BSONSplitter();
        splitter.setConf(config);
        ArrayList<FileSplit> splits = new ArrayList<FileSplit>();
        List<FileStatus> inputFiles = listStatus(context);
        for (FileStatus file : inputFiles) {
            if (pf != null && !pf.accept(file.getPath())) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(String.format("skipping file %s not matched path filter.", file.getPath()));
                }
                continue;
            } else {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("processing file " + file.getPath());
                }
            }

            splitter.setInputPath(file.getPath());

            Path splitFilePath = getSplitsFilePath(file.getPath(), config);
            try {
                splitter.loadSplitsFromSplitFile(file, splitFilePath);
            } catch (BSONSplitter.NoSplitFileException nsfe) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug(String.format("No split file for %s; building split file", file.getPath()));
                }
                splitter.readSplitsForFile(file);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug(String.format("BSONSplitter found %d splits.", splitter.getAllSplits().size()));
            }
            splits.addAll(splitter.getAllSplits());
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(String.format("Total of %d found.", splits.size()));
        }
        return splits;
    }

}