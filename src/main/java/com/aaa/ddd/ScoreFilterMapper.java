package com.aaa.ddd;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * fileName:
 * description:
 * author:zyq
 * createTime: 9:18
 */
public class ScoreFilterMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
private Text k=new Text();
private IntWritable intWritable=new IntWritable ();
  @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
 String[] values=value.toString ().split (",") ;
 double i=Double.valueOf (values[1]);

 if(i>75){
     k.set (values[0]);
     intWritable.set ((int)i);
     context.write (k,intWritable);
  context.getCounter ("NameFile","success") .increment (1);
      }else{

     context.getCounter ("NameFile","fail") .increment (1);
 }



    }
}
