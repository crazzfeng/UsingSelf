package com.study1;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yufeng li
 * @title: StudyRequest
 * @description:
 * @date 2018/12/20 11:04
 */
public class StudyRequest {

    private static String getStaticPage(String surl) {
        String htmlContent = "";
        try {
            InputStream inputStream;
            URL url = new URL(surl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.connect();
            inputStream = connection.getInputStream();
            byte[] bytes = new byte[1024 * 2000];
            int index = 0;
            int count = inputStream.read(bytes, index, 1024 * 2000);
            while (count != -1) {
                index += count;
                count = inputStream.read(bytes, index, 1);
            }
            htmlContent = new String(bytes, "UTF-8");
            connection.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return htmlContent.trim();
    }

    public static void main(String[] args) {
        try {
            /*String url1 = "http://localhost:8100/ovu-park/backstage/invest/priceRelease/list";
            String param = "parkId='af98a32c9b4d490297cadc2d85faf797'" +
                    "&currentPage=1" +
                    "&pageSize=10" +
                    "&pageIndex=0" +
                    "&totalCount=0";

            String result = getStaticPage(url1+"?"+param);
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.err.print(result);*/
            String src = getStaticPage("http://www.baidu.com");
            File file = new File("C:\\Users\\issuser\\Desktop\\aaa.html");
            FileWriter resultFile = new FileWriter(file);
            PrintWriter myFile = new PrintWriter(resultFile);// 写文件
            myFile.println(src);
            resultFile.close();
            myFile.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
