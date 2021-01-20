package JUC02.Lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {  // 资源类
    private int number  = 30;

    private Lock lock = new ReentrantLock();

    public void saleTicket () {

        lock.lock();
        try {

            if (number > 0) {
                System.out.println(Thread.currentThread().getName()+"\t卖出第"+ (number--) +"\t还剩下"+number);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

}


/**
 * 题目： 三个售票员  卖出  30张票
 *
 * 多线程编程的企业级套路+模板
 *
 * 1. 在高内聚低耦合的前提下，线程     操作(对外暴露的调用方法)    资源类
 *
 * 2.
 */
public class SaleTicket {
    public static void main(String[] args) throws Exception {
        Ticket ticket = new Ticket();

        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.saleTicket();},"A").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.saleTicket();},"B").start();
        new Thread(() -> {for (int i = 0; i < 40; i++) ticket.saleTicket();},"C").start();




        // Thread​(Runnable target, String name)  分配一个新的 Thread对象。

        /*
            thread.start()    thread准备就绪，并不是开始，需要等待底层操作系统cpu调度
         */

        /*new Thread(new Runnable() {    // 匿名内部类
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket();
                }
            }
        }, "C").start();*/


    }
}
