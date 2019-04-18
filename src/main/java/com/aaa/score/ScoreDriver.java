package com.aaa.score;

import com.aaa.mr.util.DeleteDirUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * fileName:ScoreDriver
 * description:
 * author:zz
 * createTime:2019/4/8 17:53
 */
public class ScoreDriver {
    public static void main(String[] args) {
        try {
           DeleteDirUtil.delDir("D:\\chengji\\output");
           // args = new String[]{"d:/chengji/input/","d:/chengji/output/"};
            //获取任务信息
            Configuration configuration  = new Configuration();
            Job job = Job.getInstance(configuration);
            //获取该任务使用jar包的位置
            job.setJarByClass(ScoreDriver.class);
            //关联自定义的mapper和reduce
            job.setMapperClass(ScoreMapper.class);
            job.setReducerClass(ScoreReducer.class);

            //设置mapper输出类型
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);
            //设置最终输出类型
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(Text.class);
            //设置分组
           // job.setGroupingComparatorClass(ScoreGroupSort.class);
            //设置分区
        //  job.setPartitionerClass(ScorePatitioner.class);
            //设置reduce个数
           job.setNumReduceTasks(4);

            FileInputFormat.setInputPaths(job,new Path(args[0]));
            FileOutputFormat.setOutputPath(job,new Path(args[1]));
            //设置输入输出路径
          //  FileInputFormat.setInputPaths(job,new Path(args[0]));
         //   FileOutputFormat.setOutputPath(job,new Path(args[1]));
            //提交任务
            job.waitForCompletion(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
