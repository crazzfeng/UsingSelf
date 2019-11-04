package com.study1;

import java.util.concurrent.TimeUnit;

/**
 * @author yufeng li
 * @title: StudyEquals
 * @description:
 * @date 2018/12/20 16:41
 */
public class StudyEquals implements Runnable {
    int pa1;

    public static void main(String[] args) {
        StudyEquals studyEquals = new StudyEquals();

        Thread thread1 = new Thread(studyEquals, "a1");
        Thread thread2 = new Thread(studyEquals, "a2");
        try {
            thread1.start();//启动线程执行run方法
            TimeUnit.SECONDS.sleep(3);//主线程睡眠，3秒后才往下执行，此时a1线程不受影响继续执行
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //thread1.run();//简单的调用方法，不涉及线程，此时只是使用主线程 main
        //thread2.run();
    }


    @Override
    public void run() {
        System.err.println("kaishi:"+System.currentTimeMillis());
        int i = 0;
        while (i < 100) {
            i++;
            Integer integer = get();
            integer++;
            set(integer);
            System.err.println(Thread.currentThread().getName() + ":" + get());
        }
        System.err.println("jieshu"+System.currentTimeMillis());
    }

    public void set(Integer a) {
        pa1 = a;
    }

    public Integer get() {
        return pa1;
    }

}
