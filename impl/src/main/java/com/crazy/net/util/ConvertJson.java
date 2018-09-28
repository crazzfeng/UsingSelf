package com.crazy.net.util;



import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.alibaba.fastjson.JSONArray;

/**
 * @author yufeng li
 * @title: ConvertJson
 * @description:
 * @date 2018/9/18 17:31
 */
public class ConvertJson {

    public ConvertJson() {

    }


    public static <T> T readToObject(String pathName,Class<T> clazz) {
        return JSONArray.parseObject(ConvertJson(pathName), clazz);
    }

    public static <T> List<T> readToList(String pathName,Class<T> clazz) {
        return JSONArray.parseArray(ConvertJson(pathName), clazz);
    }


    /**
     * @Title: ConvertJson
     * @Description: 将json文件转换为字符串
     * @author yufeng li
     * @param pathName json的全路径
     * @return java.lang.String
     * @throws
     */
    public static String ConvertJson(String pathName){
        try {
            File file = new File(pathName);
            InputStream inputStream = new FileInputStream(file);
            byte[] buf = new byte[1024];
            // 定义一个StringBuffer用来存放字符串
            StringBuffer sb = new StringBuffer();
            // 开始读取数据
            int len = 0;// 每次读取到的数据的长度
            while ((len = inputStream.read(buf)) != -1) {// len值为-1时，表示没有数据了
                // append方法往sb对象里面添加数据
                sb.append(new String(buf, 0, len, "utf-8"));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Title: getFilePath
     * @Description:
     * @author yufeng li
     * @param fileName 文件名
     * @return java.lang.String
     * @throws
     */
    public static String getFilePath(String fileName){

        URL url = ClassLoader.getSystemResource("");
        String path = url.getPath();
        String pathName = path+"/com.crazy.net/json/"+fileName;
        return pathName;
    }
}
