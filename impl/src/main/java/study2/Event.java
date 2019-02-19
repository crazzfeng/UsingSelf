package study2;

/**
 * @author yufeng li
 * @title: Event
 * @description:
 * @date 2019/2/19 15:18
 */
public abstract class Event {
    private long eventTime;
    protected  final long delayTime;
    public Event(long delayTime){
        this.delayTime = delayTime;
        start();
    }

    public void  start(){
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready(){
        return System.nanoTime() >= eventTime;
    }

    public  abstract void action();
}
