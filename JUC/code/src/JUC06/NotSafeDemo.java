package JUC06;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 题目：请举例说明集合类是不安全的
 */
public class NotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }


    }
}
