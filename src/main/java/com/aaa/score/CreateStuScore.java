package com.aaa.score;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * fileName:CreateStuScore
 * description:
 * author:zz
 * createTime:2019/4/8 17:22
 */
public class CreateStuScore {

    public static void main(String[] args) {
        FileWriter  fileWriter = null;
        try {
            File file = new File("d:/chengji/input/");
                if(!file.exists()){
                    file.mkdirs();
                }
            fileWriter = new FileWriter(new File("d:/aa.txt"));
            Random random = new Random();
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            for (int i = 0; i < 10; i++) {
                for (int j = 1; j < 6; j++) {
                    fileWriter.write("stu"+i+","+j+","+ decimalFormat.format( 1+(random.nextDouble()*100))+"\n");
                }
            }
            fileWriter.flush();
            System.out.println("生成完毕！！！");
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
