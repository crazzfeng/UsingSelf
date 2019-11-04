package com.study2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yufeng li
 * @title: Controller
 * @description:
 * @date 2019/2/19 15:16
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c){
        eventList.add(c);
    }

    public void run(){
        while(eventList.size() > 0){
            for (Event e : new ArrayList<>(eventList)){
                if (e.ready()){
                    System.out.print(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
