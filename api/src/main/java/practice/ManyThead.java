package practice;

import java.util.LinkedList;
import java.util.Queue;

public class ManyThead
{
    public static void main(String[] args)
    {
        Queue<String> queue = new LinkedList<String>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        queue.add("6");
        queue.add("7");
        queue.add("8");
        queue.add("9");
        queue.add("10");
        new Thread(new Consumer(queue)).start();
        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();

       /* Thread t1 = new Thread();
        Thread t2 = new Thread();

        t1.run();
        ManyThead manyThead = new ManyThead();*/

    }



}
