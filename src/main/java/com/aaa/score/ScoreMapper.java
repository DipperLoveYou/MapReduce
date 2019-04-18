package com.aaa.score;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * fileName:ScoreMapper
 * description:
 * author:zz
 * createTime:2019/4/8 17:47
 */
public class ScoreMapper extends Mapper<LongWritable,Text,Text,Text> {
    @Override
    protected void map(LongWritable key, Text value,  Context context)  throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");
        for (String string : fields) {
            System.out.print(string + "  ");
        }
        //取出科目
        String kemu = fields[0];
        //取出成绩放到新数组中去
        StringBuffer cjstr=new StringBuffer();
        for (int i = 2; i < fields.length; i++) {
            cjstr.append(fields[i]);
            if (i!=fields.length-1) {
                cjstr.append(",");
            }
        }
        context.write(new Text(kemu), new Text(cjstr.toString()));
    }
}



