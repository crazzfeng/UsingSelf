package com.random;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yufeng li
 * @title: TestRandom
 * @description:
 * @date 2019/2/28 17:27
 */
public class TestRandom {


    public static void main(String[] args) {
        try {
            SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = format.parse("2019-01-30");
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date1);
            calendar1.add(Calendar.MONTH,1);
            System.err.println("1:"+format.format(calendar1.getTime()));
            calendar1.add(Calendar.DAY_OF_YEAR,-1);
            System.err.println("2:"+format.format(calendar1.getTime()));
            System.err.println(calendar1.getActualMaximum(Calendar.DAY_OF_MONTH));

            Date date2 = format.parse("2019-02-28");
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            calendar2.add(Calendar.DAY_OF_YEAR,1);
            calendar2.add(Calendar.MONTH,1);
            calendar2.add(Calendar.DAY_OF_YEAR,-1);
            System.err.println("3:"+format.format(calendar2.getTime()));
            calendar2.add(Calendar.DAY_OF_YEAR,-1);
            System.err.println("4:"+format.format(calendar2.getTime()));
            System.err.println(calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));

           /* SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String currentTime = format1.format(new Date());
            System.err.println(currentTime);*/
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }


}
