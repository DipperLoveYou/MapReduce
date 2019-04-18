package com.aaa.demo;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * fileName:GameCountReduce
 * description:
 * author:zz
 * createTime:2019/4/2 17:42
 */
public class GameCountReduce extends Reducer<Text,Game,Text,Game> {
    @Override
    protected void reduce(Text key, Iterable<Game> values, Context context) throws IOException, InterruptedException {
        long killNum = 0;
        long kelledNum = 0;
        // chengmengyue   [game{10,5},game{10,5},game{10,5},game{10,5},game{10,5}]
        for (Game game : values) {
            killNum+=game.getKillNum();
            kelledNum+=game.getKilledNum();
        }
        context.write(key,new Game(killNum,kelledNum));
    }
}
