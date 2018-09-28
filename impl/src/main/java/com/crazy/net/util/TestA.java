package com.crazy.net.util;

/**
 * @author yufeng li
 * @title: TestA
 * @description:
 * @date 2018/9/19 10:21
 */
public class TestA {

    public static void main(String[] args) {
        String path = ConvertJson.getFilePath("test.json");
        TestC testC = ConvertJson.readToObject(path,TestC.class);
        System.err.print(testC.getSites().get(0).getHttp());
    }
}
