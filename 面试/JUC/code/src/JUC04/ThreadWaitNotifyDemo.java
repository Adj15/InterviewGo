package JUC04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者模式
 *
 * 题目：有两个线程，可以操作初始值为0的一个变量
 *       实现一个线程对该变量+1，另一个线程对该变量-1
 *       实现交替，来10轮，变量初始值为0
 *
 *  1       高内聚，低耦合前提下，线程   操纵   资源类
 *  2       判读/干活/通知
 *  3       多线程交互中，必须要防止多线程的虚假唤醒，也即（判断只用while 不用if）
 */


class AirController {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws InterruptedException{
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement() throws InterruptedException{
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }



    /*public synchronized void increment() throws InterruptedException{
        // 1 判断
        while (number != 0) {
            this.wait();
        }
        // 2 干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        // 3 通知
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        // 1 判断
        while (number == 0) {
            this.wait();
        }
        // 2 干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        // 3 通知
        this.notifyAll();
    }*/



}

public class ThreadWaitNotifyDemo {

    public static void main(String[] args) {
        AirController airController = new AirController();

        new Thread(() -> {
            for (int i = 0; i <10; i++) {
                try {
                    airController.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airController.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i <10; i++) {
                try {
                    airController.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airController.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();

    }

}
