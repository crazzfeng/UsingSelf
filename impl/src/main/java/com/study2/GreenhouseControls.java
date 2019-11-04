package com.study2;

/**
 * @author yufeng li
 * @title: GreenhouseControls
 * @description:
 * @date 2019/2/19 15:15
 */
public class GreenhouseControls extends Controller{
    //灯
    public boolean light = false;
    public class LightOn extends Event{

        public LightOn(long delayTime){
            super(delayTime);
        }

        public void action(){
            light = true;
        }

        public String toString(){
            return "Light is on\n";
        }
    }

    public class LightOff extends Event{

        public LightOff(long delayTime){
            super(delayTime);
        }

        public void action(){
            light = false;
        }

        public String toString(){
            return "Light is off\n";
        }
    }

    //水
    private boolean water = false;
    public class WaterOn extends  Event{
        public WaterOn(long delayTime){
            super(delayTime);
        }
        public void action(){
            light = true;
        }

        public String toString(){
            return "Greenhouse water is on\n";
        }
    }

    public class WaterOff extends  Event{
        public WaterOff(long delayTime){
            super(delayTime);
        }
        public void action(){
            light = false;
        }

        public String toString(){
            return "Greenhouse water is off\n";
        }
    }

    //当前时间状态--白天和黑夜
    private String thermostat = "Day";
    public class  ThermostatNight extends Event{
        public ThermostatNight(long delayTime){
            super(delayTime);
        }
        public void action(){
            thermostat = "Night";
        }

        public String toString(){
            return "Thermostat on night setting\n";
        }
    }

    public class  ThermostatDay extends Event{
        public ThermostatDay(long delayTime){
            super(delayTime);
        }
        public void action(){
            thermostat = "Day";
        }

        public String toString(){
            return "Thermostat on day setting\n";
        }
    }

    //响铃
    public class  Bell extends Event{
        public Bell(long delayTime){
            super(delayTime);
        }
        public void action(){
            //addEvent(new Bell(delayTime));
        }

        public String toString(){
            return "Bing\n";
        }
    }

    //重启
    public class  Restart extends Event{
        private Event[] eventList;
        public Restart(long delayTime,Event[] eventList){
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList){
              //  addEvent(e);
            }
        }
        public void action(){
            for (Event e : eventList){
                e.start();
                //addEvent(e);
            }
            start();
            //addEvent(this);
        }

        public String toString(){
            return "Restarting system\n\n";
        }
    }


    public static class Terminate extends Event{
        public Terminate(long delayTime){
            super(delayTime);
        }

        public void action(){
            System.exit(0);
        }

        public String toString(){
            return "Terminating\n";
        }
    }
}
