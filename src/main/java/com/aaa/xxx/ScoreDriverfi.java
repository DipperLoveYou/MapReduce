package com.aaa.xxx;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ScoreDriverfi {

    public static void main(String[] args) {
        args = new String[]{"d:/chengji/input/","d:/chengji/output/"};
        try {
            //获取任务信息
            Configuration configuration  = new Configuration();
            Job job = Job.getInstance(configuration);
            //获取该任务使用jar包的位置
            job.setJarByClass(ScoreDriverfi.class);
            //关联自定义的mapper和reduce
            job.setMapperClass(ScoreMapperfi.class);
            job.setReducerClass(ScoreReducerfi.class);
            //设置mapper输出类型
            job.setMapOutputKeyClass(Finnd.class);
            job.setMapOutputValueClass(Text.class);
            //设置最终输出类型
            job.setOutputKeyClass(Finnd.class);
            job.setOutputValueClass(Text.class);
            //设置输入输出路径
            FileInputFormat.setInputPaths(job,new Path(args[0]));
            FileOutputFormat.setOutputPath(job,new Path(args[1]));

            //job.setPartitionerClass(ScorePartitleoner.class);
            //设置reduce数量
            job.setNumReduceTasks(3);
            //提交任务
            job.waitForCompletion(true);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
