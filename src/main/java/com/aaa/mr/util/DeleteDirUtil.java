package com.aaa.mr.util;

import java.io.File;

/**
 * fileName:DeleteDirUtil
 * description:
 * author:zz
 * createTime:2019/4/10 14:55
 */
public class DeleteDirUtil {

    /**
     * 公用删除方法
     * @param path
     * @return
     */
    public static boolean delDir(String path){
        File file = new File(path);
        if(file.isDirectory()){
            //列出该目录下所有文件，遍历删除
            File[] files = file.listFiles();
            for (File file1 : files) {
                file1.delete();
            }
            //删除目录
           return  file.delete();
        }
        return false;
    }
}
