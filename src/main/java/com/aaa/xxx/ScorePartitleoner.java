package com.aaa.xxx;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class ScorePartitleoner extends Partitioner<Finnd,Text> {
    @Override
    public int getPartition(Finnd fint, Text text, int i) {
        String subjectName = text.toString ();
        if (subjectName.equals ("math")) {
            return 1;
        } else if (subjectName.equals ("english")) {
            return 2;
        } else if (subjectName.equals ("computer")) {
            return 3;
        } else if (subjectName.equals ("algorithm")) {
            return 4;
        } else {
            return 0;
        }
    }
}