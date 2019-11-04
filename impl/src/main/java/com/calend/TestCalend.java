package com.calend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yufeng li
 * @title: TestCalend
 * @description:
 * @date 2019/9/8 10:14
 */
public class TestCalend {


    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = "2019-03-01";
        String date2 = "2019-07-01";
        try {
            Calendar start = Calendar.getInstance();
            start.setTime(format.parse(date1));
            /*start.set(Calendar.DATE,0);
            System.err.println(format.format(start.getTime()));*/
            Calendar end = Calendar.getInstance();
            end.setTime(format.parse(date2));
            TestCalend testCalend = new TestCalend();
            testCalend.printBill(start, end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public void printBill(Calendar start, Calendar end) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int dayOfMonth = start.get(Calendar.DATE);
        int i = 1;
        while (start.compareTo(end) <= 0) {
            Date billStart = start.getTime();
            Date billEnd = getBillEndDate(start, dayOfMonth).getTime();
            if (billEnd.compareTo(end.getTime()) > 0) {
                billEnd = end.getTime();
            }
            System.err.println("第" + i + "期账单，开始日期：" + format.format(billStart) + ",结束日期：" + format.format(billEnd) + "\n");
            i++;
            start.add(Calendar.DATE,1);
        }
    }


    public Calendar getBillEndDate(Calendar start, int dayOfMonth) {
        start.add(Calendar.MONTH, 1);
        start.add(Calendar.DATE, -1);
        int maxDay = start.getActualMaximum(Calendar.DATE);
        if (dayOfMonth > maxDay || dayOfMonth == 1) {
            start.set(Calendar.DATE, maxDay);
        }else{
            start.set(Calendar.DATE, dayOfMonth);
            start.add(Calendar.DATE, -1);
        }
        return start;
    }
}
