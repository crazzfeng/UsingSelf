package com.crazy.net.util;

import java.util.*;

/**
 * @author yufeng li
 * @title: UtilTest
 * @description:
 * @date 2018/9/18 15:27
 */
public class UtilTest {

    public static void main(String[] args) {
      /*  List<String> strings  =new ArrayList<String>();
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");
        strings.add("ddd");
        strings.add("eee");
        strings.add("fff");
        strings.add("jjj");
        strings.add("ggg");
        strings.add("hhh");
        strings.add("iii");

        List<Integer> integers  =new ArrayList<Integer>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);
        integers.add(10);

        integers.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1.compareTo(o2)>0){
                    return -1;
                }else if (o1.compareTo(o2)==0)
                {
                    return 0;
                }
                else
                {
                    return 1;
                }
            }
        });
        int i = Collections.binarySearch(integers,10);
        System.err.print(i);*/

        System.err.print(tableSize(3));
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    private static int tableSize(int cap){
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
