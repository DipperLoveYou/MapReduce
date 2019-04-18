package com.aaa.ddd;

import com.aaa.mr.util.DeleteDirUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * fileName:
 * description:
 * author:zyq
 * createTime: 9:18
 */
public class ScoreFilterDriver {
    public static void main(String[] args) {

        try {
        //    DeleteDirUtil.delDir("D:\\chengji\\nf\\output");
            //获取任务信息
            Configuration configuration  = new Configuration();
            Job job = Job.getInstance(configuration);
            //获取该任务使用jar包的位置
            job.setJarByClass(ScoreFilterDriver.class);
            //关联自定义的mapper和reduce
            job.setMapperClass(ScoreFilterMapper.class);
            //job.setReducerClass(GameCountReduce.class);

            //设置mapper输出类型
            //   job.setMapOutputKeyClass(Text.class);
            //   job.setMapOutputValueClass(Game.class);
            //设置最终输出类型
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            //设置自定义分区
            /// job.setPartitionerClass(GameCountPartitioner.class);
            //设置reduce数量
            job.setNumReduceTasks(0);
//DeleteDirUtil.delDir ("D:\\chengji\\fn\\outaaa");
           FileInputFormat.setInputPaths(job,new Path ("D:\\chengji\\output"));
            FileOutputFormat.setOutputPath(job,new Path("D:\\chengji\\outaaa"));
            //    //设置输入输出路径
            //   FileInputFormat.setInputPaths(job,new Path (args[0]));
            //  FileOutputFormat.setOutputPath(job,new Path(args[1]));
            //提交任务
            job.waitForCompletion(true);
        } catch (Exception e) {
            e.printStackTrace();
        }






    }


}

