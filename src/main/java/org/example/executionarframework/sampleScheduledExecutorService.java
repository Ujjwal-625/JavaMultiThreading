package org.example.executionarframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class sampleScheduledExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(2);

        //Schedule
        //        Runnable r= ()->{
//            System.out.println("this will run after 5 sec");
//        };
//        scheduledExecutorService.schedule(new Thread(r),2, TimeUnit.SECONDS);
//        try {
//            scheduledExecutorService.awaitTermination(4,TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        scheduledExecutorService.shutdown();
//        System.out.println(scheduledExecutorService.isShutdown());
//        System.out.println(scheduledExecutorService.isTerminated());

        //scheduleFixedRate
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("run after every 2 sec");
        },2,2,TimeUnit.SECONDS);

        //to stop this for running infinitly
        scheduledExecutorService.schedule(()->{
            System.out.println("shuting down all task....");
            scheduledExecutorService.shutdown();
        },10,TimeUnit.SECONDS);

    }
}
