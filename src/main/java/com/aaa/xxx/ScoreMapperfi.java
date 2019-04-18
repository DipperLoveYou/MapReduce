package com.aaa.xxx;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ScoreMapperfi extends Mapper<LongWritable,Text,Finnd,Text> {
         private  Finnd  fi = new Finnd();
         private  Text text = new Text();
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String[] values = value.toString().split(",");
            System.out.println(values[1]);
            text.set(values[0]);
            fi.setFindId(Integer.parseInt(values[3]));
             fi.setFindIden(Double.valueOf(values[4]));
            context.write(fi,text);
        }
}
