package com.study2;

/**
 * @author yufeng li
 * @title: GreenhouseController
 * @description:
 * @date 2019/2/19 15:50
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
       // gc.addEvent(gc.new Bell(9000000000L));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(2000000000L),
                gc.new LightOff(4000000000L),
                gc.new WaterOn(6000000000L),
                gc.new WaterOff(8000000000L),
                gc.new ThermostatDay(14000000000L)
        };
       // gc.addEvent(gc.new Restart(20000000000L,eventList));
        if (args.length == 1){
          //  gc.addEvent(new GreenhouseControls.Terminate(
          //          new Integer(args[0])
           // ));
        }
        //gc.run();

    }
}
