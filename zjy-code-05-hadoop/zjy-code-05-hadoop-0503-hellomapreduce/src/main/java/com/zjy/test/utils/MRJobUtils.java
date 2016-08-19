package com.zjy.test.utils;

import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Mapper.Context;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zjy on 2016/8/6.
 */
public class MRJobUtils {
    public static Map<String,String> cacheDeptInfoFromSmallFile(Context context) throws IOException {
        Map<String, String> deptInfoMap = new HashMap<String, String>();

        BufferedReader bufferedReader = null;

        Path[] localCacheFiles = DistributedCache.getLocalCacheFiles(context.getConfiguration());
        String deptLine;
        for (Path localCacheFile : localCacheFiles) {

            if (localCacheFile.toString().contains("dept")) {
                bufferedReader = new BufferedReader(new FileReader(localCacheFile.toString()));

                while (null != (deptLine = bufferedReader.readLine())) {
                    String[] deptInfo = deptLine.split(",");
                    deptInfoMap.put(deptInfo[0], deptInfo[1]);
                }
            }
        }

        if (bufferedReader != null) {
            bufferedReader.close();
        }
        return deptInfoMap;
    }

    public static Map<String, String> cacheCityInfoFromSmallFile(Context context) throws IOException {
        Map<String, String> cityInfoMap = new HashMap<String, String>();

        BufferedReader bufferedReader;
        Path[] localCacheFiles = DistributedCache.getLocalCacheFiles(context.getConfiguration());
        String deptLine;
        for (Path localCacheFile : localCacheFiles) {
            if (localCacheFile.toString().contains("dept")) {
                bufferedReader = new BufferedReader(new FileReader(localCacheFile.toString()));
                while (null != (deptLine = bufferedReader.readLine())) {
                    String[] deptInfo = deptLine.split(",");
                    cityInfoMap.put(deptInfo[0], deptInfo[2]);
                }
            }
        }

        return cityInfoMap;
    }
}
