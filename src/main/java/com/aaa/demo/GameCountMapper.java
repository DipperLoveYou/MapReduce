package com.aaa.demo;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * fileName:GameCountMapper
 * description:
 * author:zz
 * createTime:2019/4/2 17:24
 */
public class GameCountMapper extends Mapper<LongWritable,Text,Text,Game> {

    private Text text = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //f395f314c1,chenmengyue,2019-04-02 17:19:24,6,7,3571
        String[] values = value.toString().split(",");
        text.set(values[1]);
        context.write(text,new Game(Long.valueOf(values[3]),Long.valueOf(values[4])));
    }
}
