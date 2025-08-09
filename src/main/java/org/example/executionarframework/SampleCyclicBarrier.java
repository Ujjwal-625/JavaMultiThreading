package org.example.executionarframework;

import java.util.concurrent.*;

public class SampleCyclicBarrier {
    public static void main(String[] args) {
        int noOfService=3;
        CyclicBarrier barrier=new CyclicBarrier(noOfService);
        ExecutorService executorService=Executors.newFixedThreadPool(noOfService);
        executorService.submit(new D1Service(barrier));
        executorService.submit(new D1Service(barrier));
        executorService.submit(new D1Service(barrier));

        System.out.println("Main Running");
        executorService.shutdown();
    }
}

class D1Service implements Callable<String> {

    private CyclicBarrier barrier;

    D1Service(CyclicBarrier barrier){
        this.barrier=barrier;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println("wait for 2 sec....");
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
           barrier.await();
        }
        return "Calling the call method of the callable interface";
    }
}