package com.dayet;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import javax.xml.crypto.Data;
import java.io.*;

public class Hdfatest {

    FileSystem fs;
    public void close() throws Exception{
//
    }
    public void mkdir(){
        Path path = new Path("/dasd");
    }
    public void blksa() throws IOException {
        Path path = new Path("/dsadas");
        FSDataOutputStream fsDataOutputStream = fs.create(path);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("")));
        int i = 1232;
        IOUtils.copyBytes(inputStream,fsDataOutputStream,i,true);
    }
    public void blks() throws IOException {
        FileStatus fileStatus = fs.getFileStatus(new Path("/fsda"));
        BlockLocation[] blockLocations = fs.getFileBlockLocations(fileStatus,0,fileStatus.getLen());
        for (BlockLocation b:blockLocations
             ) {
            System.out.println(b);
        }
    }





}
