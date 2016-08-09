/*
 * Copyright 2010-2013 10gen Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zjy.mongo.mapred.output;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;


public class BSONFileRecordWriter<K, V> extends com.zjy.mongo.output.BSONFileRecordWriter implements RecordWriter<K, V> {

    public BSONFileRecordWriter(final FSDataOutputStream outFile, final FSDataOutputStream splitFile, final long splitSize) {
        super(outFile, splitFile, splitSize);
    }

    public void close(final Reporter reporter) throws IOException {
        this.close((TaskAttemptContext) null);
    }

}

