package org.example.executionarframework;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SampleCountDownLatch {
    public static void main(String[] args) {

        int noOfService=3;
        CountDownLatch latch=new CountDownLatch(noOfService);
        ExecutorService executorService= Executors.newFixedThreadPool(noOfService);

        executorService.submit(new DService(latch));
        executorService.submit(new DService(latch));
        executorService.submit(new DService(latch));

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Running the main method");
        executorService.shutdown();

    }
}


class DService implements Callable<String> {

    private CountDownLatch latch;

    DService(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println("wait for 2 sec....");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            latch.countDown();
        }
        return "Calling the call method of the callable interface";
    }
}
