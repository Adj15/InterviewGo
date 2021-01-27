package JUC11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
  * 阻塞队列
  */
public class BlockingQueueDemo {

        public static void main(String[] args) throws InterruptedException {

            BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

            // 第一组
            /*System.out.println(blockingQueue.add("a"));
            System.out.println(blockingQueue.add("b"));
            System.out.println(blockingQueue.add("c"));

//            System.out.println(blockingQueue.add("x"));

            System.out.println(blockingQueue.element());

            System.out.println(blockingQueue.remove());
            System.out.println(blockingQueue.remove());
            System.out.println(blockingQueue.remove());*/

//            System.out.println(blockingQueue.remove());

            //第二组
            /*System.out.println(blockingQueue.offer("a"));
            System.out.println(blockingQueue.offer("b"));
            System.out.println(blockingQueue.offer("c"));
            System.out.println(blockingQueue.offer("xx"));

            System.out.println(blockingQueue.peek());

            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll());*/

            //第三组
            /*blockingQueue.put("a");
            blockingQueue.put("a");
            blockingQueue.put("a");
//            blockingQueue.put("a");

            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
//            System.out.println(blockingQueue.take());*/

            //第四组
            System.out.println(blockingQueue.offer("a"));
            System.out.println(blockingQueue.offer("b"));
            System.out.println(blockingQueue.offer("c"));
            System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));


        }
}
