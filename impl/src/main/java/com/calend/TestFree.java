package com.calend;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author yufeng li
 * @title: TestFree
 * @description:
 * @date 2019/9/9 16:19
 */
public class TestFree {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("一");
        stringList.add("二");
        stringList.add("三");
        stringList.add("四");
        stringList.add("五");
        stringList.sort(Comparator.comparing(s -> s));

        for (String s : stringList){
            System.err.println(s);
        }

    }





}
