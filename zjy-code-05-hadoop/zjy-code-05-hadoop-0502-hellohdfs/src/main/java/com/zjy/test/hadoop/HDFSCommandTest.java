package com.zjy.test.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.*;

/**
 * <pre>
 * Created with IntelliJ IDEA.
 * User: zjylllf
 * Date: 2016/7/29
 * Time: 11:23
 * To change this template use File | Settings | File Templates.
 * </pre>
 *
 * @author zhangjiyong
 */
public class HDFSCommandTest {

    public static void main(String[] args) {
        try {
            final FileSystem fileSystem = FileSystem.get(new Configuration());
            String path = "/user/zjy/test/";
            lsTest(fileSystem,path);
//            mkdirTest(fileSystem, path);
//
//            path = "/user/zjy/test/test1.txt";
//            createFileTest(fileSystem, path);
//
//            writeContextTest(fileSystem, path);
//            readContentTest(fileSystem, path);


//            String srcPath = "E:\\myspace\\code\\zjy-code\\zjy-code-05-hadoop\\zjy-code-05-hadoop-0502-hellohdfs\\src\\main\\resources\\test.txt";
//            uploadFileToHDFSTest(fileSystem, srcPath, path);


            String srcPath = "/user/zjy/test/test.txt";
            String dstPath = "D:/download";
            dwdFileFromHDFSTest(fileSystem, srcPath, dstPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void mkdirTest(FileSystem fileSystem,String path) throws IOException {
        Path f = new Path(path);
        boolean mkdirs = false;
        if (fileSystem.exists(f)) {
            System.out.println(path + " already exists.");
            mkdirs = fileSystem.mkdirs(f);
        } else {
            mkdirs = fileSystem.mkdirs(f);
        }
        System.out.println(f + " create success = " + mkdirs);

    }

    public static void lsTest(FileSystem fileSystem,String pathStr) throws IOException {

        Path path = new Path(pathStr);

        final boolean exists = fileSystem.exists(path);
        if (exists) {
            final RemoteIterator<LocatedFileStatus> locatedFileStatusRemoteIterator = fileSystem.listFiles(path, true);
            while (locatedFileStatusRemoteIterator.hasNext()) {
                final LocatedFileStatus next = locatedFileStatusRemoteIterator.next();
                System.out.println(next.getPath().toString() +"++++++++");
                System.out.println(next.getPath().toUri().toString()+"===========");
            }

        }
        System.out.println(exists);
    }

    public static void createFileTest(FileSystem fileSystem,String pathStr) throws IOException {
        Path path = new Path(pathStr);
        fileSystem.create(path);
    }

    public static void writeContextTest(FileSystem fileSystem, String pathStr) throws Exception {
        Path path = new Path(pathStr);
        FileInputStream in = new FileInputStream(new File("E:\\myspace\\code\\zjy-code\\zjy-code-05-hadoop\\zjy-code-05-hadoop-0502-hellohdfs\\src\\main\\resources\\test.txt"));
        FSDataOutputStream fsDataOutputStream = fileSystem.create(path, new Progressable() {
            public void progress() {
                System.out.println("*");
            }
        });

//        in.skip(100);
        byte[] buffer = new byte[40];
        int read = 0;

        while ((read = in.read(buffer)) > 0) {

            fsDataOutputStream.write(buffer, 0, read);
        }


        IOUtils.closeStream(in);
        IOUtils.closeStream(fsDataOutputStream);
    }

    /**
     * 读取文件内容
     * @param fileSystem
     * @param pathStr
     * @throws IOException
     */
    public static void readContentTest(FileSystem fileSystem, String pathStr) throws IOException {
        Path path = new Path(pathStr);

        FSDataInputStream open = fileSystem.open(path);
        IOUtils.copyBytes(open, System.out, 4096, false);
        IOUtils.closeStream(open);
    }


    /**
     * 上传文件
     * @param fileSystem
     * @param srcPath
     * @param dstPath
     * @throws IOException
     */
    public static void uploadFileToHDFSTest(FileSystem fileSystem, String srcPath, String dstPath) throws IOException {

        fileSystem.copyFromLocalFile(new Path(srcPath),new Path(dstPath));
    }

    /**
     * 下载文件
     * @param fileSystem
     * @param srcPath
     * @param dstPath
     * @throws IOException
     */
    public static void dwdFileFromHDFSTest(FileSystem fileSystem, String srcPath, String dstPath) throws IOException {

        fileSystem.copyToLocalFile(new Path(srcPath), new Path(dstPath));
    }
}
