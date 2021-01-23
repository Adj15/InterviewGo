package JUC07;

import java.util.concurrent.TimeUnit;


class Phone {

    public static synchronized void sendEmail() throws Exception {
        try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("----sendEmail");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println("----sendSMS");
    }

    public void hello() throws Exception {
        System.out.println("----hello");
    }

}

/**
 * 题目：多线程8锁
 * 1    标准访问，请问先打印邮件还是先发短信
 * 2    邮件方法暂定4s，请问先打印邮件还是短信？
 * 3    新增一个普通方法hello（），请问先打印邮件还是hello
 * 4    两部手机请问先打印邮件还是短信
 * 5    两个静态同步方法，同一部手机，请问先打印邮件还是短信
 * 6    两个静态同步方法，两部手机，请问先打印邮件还是短信
 * 7    一个普通同步方法，一个静态同步方法，1部手机，请问先打印邮件还是短信
 * 8    一个普通同步方法，一个静态同步方法，2部手机，请问先打印邮件还是短信
 */

public class Lock8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
                //phone.sendSMS();
                //phone.hello();
                phone2.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();



    }
}
