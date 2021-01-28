package JUC12;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try {
            // 模拟有10个顾客来银行办理业务，目前线程池中有5个工作人员提供服务
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
//                    try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t正在办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


    }

    private static void initPool() {
        //        ExecutorService threadPool = Executors.newFixedThreadPool(5);     // 一个线程池中有5个工作线程，模拟一个银行有5个受理窗口
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 一个线程池中有1个工作线程，模拟一个银行有1个受理窗口
        ExecutorService threadPool = Executors.newCachedThreadPool();       // 一个线程池中有N个工作线程，模拟一个银行有N个受理窗口


        try {
            // 模拟有10个顾客来银行办理业务，目前线程池中有5个工作人员提供服务
            for (int i = 0; i < 10; i++) {
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                threadPool.execute(() -> {
//                    try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t正在办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static class Test{
        public void test() {

        }
    }



}

