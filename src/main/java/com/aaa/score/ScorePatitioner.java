package com.aaa.score;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * fileName:
 * description:
 * author:zyq
 * createTime: 0:41
 */
public class ScorePatitioner  extends Partitioner<Text,Score> {
    @Override
    public int getPartition(Text text, Score score, int i) {
        String subjectName = text.toString ().split ("@")[1];
        if (subjectName.startsWith ("english")) {
            return 1;
        } else if (subjectName.startsWith ("algorithm")) {
            return 2;
        } else if (subjectName.startsWith ("computer")) {
            return 3;
        } else if (subjectName.startsWith ("math")){
            return 4;
        }else{
            return 0;
        }
    }}
