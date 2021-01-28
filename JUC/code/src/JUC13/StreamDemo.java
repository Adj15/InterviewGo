package JUC13;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


class User{
    private Integer id;
    private String username;
    private int age;

    public User(Integer id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}


/**
 * 题目：请按照给出数据，找出同时满足以下条件的用户，也即以下条件全部满足
 *        偶数ID且年龄大于24且用户名转为大写且用户名字母到排序
 *        只输出一个用户名字
 */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        list.stream()
            .filter(t -> {return t.getId() % 2 == 0;})
            .filter(t -> {return t.getAge() > 24;})
            .map(s -> {return s.getUsername().toUpperCase();})
            .sorted(((o1, o2) -> {return o2.compareTo(o1);}))
            .limit(1)
            .forEach(System.out::println);



        /*// 四大函数式接口
        // 函数型接口 Function<T,R>
        *//*Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };*//*
        Function<String, Integer> function = s -> {return s.length();};
        System.out.println(function.apply("abc"));


        // 断定型接口 Predicate<T>
        *//*Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };*//*
        Predicate<String> predicate = s -> {return s.isEmpty();};
        System.out.println(predicate.test("abc"));

        // 消费型接口 Consumer<T>
        *//*Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };*//*
        Consumer<String> consumer = s -> { System.out.println(s); };
        consumer.accept("abc");

        // 供给型接口 Supplier<T>
        *//*Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "123";
            }
        };*//*
        Supplier<String> supplier = () -> {return "123";};
        System.out.println(supplier.get());*/


    }
}
