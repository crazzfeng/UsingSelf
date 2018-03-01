package practice;

import java.util.Queue;

public class Consumer implements Runnable
{
    private Queue<String> strings;

    public Consumer(Queue<String> strings)
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
                while (strings.isEmpty())
                {
                    System.out.println("消费线程" + Thread.currentThread().getId() + "执行，队列为空，消费者等待");
                    strings.wait();
                }
                System.out.println("消费线程" + Thread.currentThread().getId() + "执行，队列不为空，消费者消费:" + strings.remove() + "，容量" + strings.size());
                strings.notifyAll();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
