package practice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;

public class Producer implements Runnable
{
    private Queue<String> strings;

    public Producer(Queue<String> strings)
    {
        this.strings = strings;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run()
    {
        synchronized (strings)
        {
            try
            {
                while (strings.size() == 10)
                {
                    System.out.println("生产线程" + Thread.currentThread().getId() + "执行，队列为满，生产者等待");
                    strings.wait();
                }

                Long aLong = System.currentTimeMillis();
                Date date = new Date(aLong);
                SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = sdf.format(date);
                strings.add(time);
                System.out.println("生产线程" + Thread.currentThread().getId() + "执行，队列不为满，生产者生产：" + String.valueOf(System.currentTimeMillis()) + "，容量" + strings.size());
                strings.notifyAll();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}