package com.zjy;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zjy on 2016/8/17.
 */
public class Test1 {
    public static void main(String[] args) {

        Set<String> stringSet1 = test0();
        Set<String> stringSet2 = test3();
        Set<String> stringSet3 = test4();
        System.out.println(stringSet3.containsAll(stringSet2));
//        System.out.println(stringSet3.containsAll(stringSet1));

       /* for (String s : stringSet2) {
            boolean contains = stringSet3.contains(s);
            if (!contains) {
                System.out.println(s);
            }
        }*/


        for (String s : stringSet1) {
            if (!stringSet2.contains(s)) {
                System.out.println(s);
            }
        }


    }


    public static Set<String> test0() {
        Set<String> dmpIdSet = new HashSet<String>();
        try {
            List<String> list = FileUtils.readLines(new File("E:\\temp\\data\\lppz\\lppz-cm3.txt"));
            Set<String> dmpId360Set = new HashSet<String>();

            int count360DmpId = 0;
            int countSdycDmpId = 0;
            for (String line : list) {
                String[] split = line.split("\t");
                countSdycDmpId++;
                dmpIdSet.add(split[2]);
                String[] split1 = split[0].replaceAll("\"", "").replaceAll("[{]", "").replaceAll("[}]", "").split(",");
                for (String s : split1) {
                    count360DmpId++;
                    String s1 = s.split(":")[0];
                    dmpId360Set.add(s1);
//                    System.out.println(s1);
                }

            }
            System.out.println("HBASE 表中360的DMPID未去重:" + count360DmpId);
            System.out.println("HBASE 表中360的DMPID去重后:" + dmpId360Set.size());
            System.out.println("HBASE 表中sdyc的DMPID未去重:" + countSdycDmpId);
            System.out.println("HBASE 表中sdyc的DMPID去重后:" + dmpIdSet.size());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dmpIdSet;

    }

    public void test1() {
        try {
            List<String> list = FileUtils.readLines(new File("E:\\temp\\data\\lppz\\lppz-cm2.txt"));
            int count = 0;
            for (String line : list) {
                String[] split = line.split("\t");
                if (!split[0].equals("{}") && !split[1].equals("NULL")) {
                    long last = Long.parseLong(split[1]);
                    if (last < 1471366800000L & last > 1471280400000L) {

                        count++;
                        System.out.println(line);
                    }
                }

            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void test2() {
        try {
            List<String> list = FileUtils.readLines(new File("E:\\temp\\data\\lppz\\s213_tracker.log\\s212_tracker.log.2016-08-16"));
            for (String line : list) {
                if (line.contains("##")) {
                    System.out.println(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<String> test3() {
        Set<String> dmpIdSet = new HashSet<String>();
        try {
            List<String> list = FileUtils.readLines(new File("E:\\temp\\data\\lppz\\s213_tracker.log\\cookie.log"));
            Set<String> dmpId360Set = new HashSet<String>();
            Set<String> resutltSet = new HashSet<String>();


            int countCM = 0;
            for (String line : list) {
                String[] split = line.split("##");
                if (split.length == 3) {

                    countCM++;
                    resutltSet.add(line);
                    String dmpId = split[0];
                    if (dmpId != null && !"".equals(dmpId)) {

                        dmpIdSet.add(dmpId);
                    }
                    String dmpId360 = split[2];
                    if (dmpId360 != null && !"".equals(dmpId360)) {
                        dmpId360Set.add(dmpId360);
                    }
                }


            }

            System.out.println("tracker日志中CM对未去重:" + countCM);
            System.out.println("tracker日志中CM对去重后:" + resutltSet.size());

            System.out.println("tracker日志中360的DMPID未去重:" + countCM);
            System.out.println("tracker日志中360的DMPID去重后:" + dmpId360Set.size());
            System.out.println("tracker日志中sdyc的DMPID未去重:" + countCM);
            System.out.println("tracker日志中sdyc的DMPID去重后:" + dmpIdSet.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dmpIdSet;
    }

    public static Set<String> test4() {
        Set<String> dmpIdSet = new HashSet<String>();
        try {
            List<String> list = FileUtils.readLines(new File("E:\\temp\\data\\lppz\\lppz-act.txt"));


            int countCM = 0;
            for (String line : list) {
                String[] split = line.split("\t");
                if (split.length == 4) {

                    countCM++;
                    String dmpId = split[0];
                    dmpIdSet.add(createDmpId(dmpId, 201));

                }


            }


            System.out.println("原始数据中访问lppz未去重:" + countCM);
            System.out.println("原始数据中访问lppz的DMPID去重后:" + dmpIdSet.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dmpIdSet;
    }

    public static final String createDmpId(String audId, int typeId) {
        int length = audId.length();
        int lengthx = String.valueOf(length).length();
        String dmpId = audId + typeId + audId.length() + lengthx;
        return DigestUtils.md5Hex(dmpId);
    }
}



