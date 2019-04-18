package com.aaa.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * fileName:CreateGameData
 * description:
 * author:zz
 * createTime:2019/4/2 16:57
 */
public class CreateGameData {

    public static void main(String[] args) {
        FileWriter fileWriter  = null;
        try {
            fileWriter  =new FileWriter(new File("d:/game33.txt"));

            String[] pName = {"guoqiming@zhengzhou","hechaoqi@zhengzhou","sunshiwen@shenzhen","lidonglong@shenzhen","xuyanpeng@guangzhou","chenmengyue@guangzhou","zhanghaodong@shanghai","huogaoxu@shanghai","shimingyi@beijing","jiaojian@beijing"};
            String[] cityName = {"zhengzhou","shenzhen","guangzhou","shanghai","beijing"};
            Random random = new Random();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (int i = 1; i <= 1000000; i++) {
                String tid = UUID.randomUUID()+""+i;
                tid = tid.substring(tid.length()-10);
                fileWriter.write(tid+","+pName[random.nextInt(10)]+","
                        +simpleDateFormat.format(new Date())+","+random.nextInt(20)+","+random.nextInt(10)+","+random.nextInt(15000)+","+cityName[random.nextInt(5)]+"\n");
            }

            fileWriter.flush();
            System.out.println("文件生成完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileWriter!=null){
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
