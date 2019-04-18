package com.aaa.xxx;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ScoreReducerfi extends Reducer<Finnd, Text,Finnd,Text> {
    @Override
    protected void reduce(Finnd key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        context.write(key,values.iterator().next());
    }
}
