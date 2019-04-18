package com.aaa.score;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * fileName:ScoreReducer
 * description:
 * author:zz
 * createTime:2019/4/8 17:51
 */
public class ScoreReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int count=0;//总人数
        double avgofone;//平均值
        double avg;//平均数
        int sumall=0;//科目总数
        for (Text text : values) {
            //一个人的平均成绩
            String[] str = text.toString ().split (",");
            int sum = 0;
            int num = 0;
            for (String string : str) {
                sum += Integer.parseInt (string);
                num++;
            }
            avgofone = (sum / num);
            count++;
            sumall += avgofone;
            //一个科目的平均成绩
            avg = sumall / count;//科目总和/总数
            String outString = count + "," + avg;
            Text t = new Text (outString);
            context.write (key, t);
        }





    }
}