package com.aaa.demo;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * fileName:GameCountPartitioner
 * description:
 * author:zz
 * createTime:2019/4/8 14:42
 */
public class GameCountPartitioner extends Partitioner<Text,Game> {
    //{"guoqiming","hechaoqi","sunshiwen","lidonglong","xuyanpeng","chenmengyue","zhanghaodong","huogaoxu","shimingyi","jiaojian"};
    @Override
    public int getPartition(Text text, Game game, int i) {
        //String userName = text.toString();
        //
        String cityName = text.toString().split("@")[1];
       /* if(userName.startsWith("guo")||userName.startsWith("he")){
            return 1;
        }else if(userName.startsWith("sun")||userName.startsWith("li")){
            return 2;
        }else if(userName.startsWith("xu")||userName.startsWith("chen")){
            return 3;
        }else{
            return 0;
        }*/
       //{"zhengzhou","shenzhen","guangzhou","shanghai","beijing"};
        if(cityName.startsWith("zhengzhou")){
            return 1;
        }else if(cityName.startsWith("shenzhen")){
            return 2;
        }else if(cityName.startsWith("guangzhou")){
            return 3;
        }else{
            return 0;
        }
    }
}
