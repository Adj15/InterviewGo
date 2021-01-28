package JUC15;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回，update mysql ok");
        });
        voidCompletableFuture.get();*/

        // 异步回调
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t completableFuture2");
//            int age = 10/0;
            return 1024;
        });

        /*completableFuture.whenComplete((t,u) -> {
            System.out.println("----t:"+t);
            System.out.println("----u:"+u);
        }).exceptionally(f -> {
            System.out.println("----exception:"+f.getMessage());
            return 404;
        }).get();*/

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("----t:" + t);
            System.out.println("----u:" + u);
        }).exceptionally(f -> {
            System.out.println("----exception:" + f.getMessage());
            return 404;
        }).get());

    }
}
