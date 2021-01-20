package JUC03;

interface Foo {
    public void sayHello();
}

@FunctionalInterface
interface Test {
    public int add(int a, int b);

    default int div(int a, int b) {
        System.out.println("***********hello Lambda");
        return a/b;
    }

    default int div2(int a, int b) {
        System.out.println("***********hello Lambda");
        return a/b;
    }

}

/**
 * 2  Lambda Express
 *    2.1  拷贝小括号（），写死右箭头->，落地大括号{...}
 *
 *    2.2  @FunctionalInterface
 *
 *    2.3  default 函数可以无限个
 *
 *    2.4  静态方法实现
 */

public class LambdaExpressDemo {
    public static void main(String[] args) {

         Foo foo = new Foo() {
             @Override
             public void sayHello() {
                 System.out.println("hello world!!");
             }
         };
         foo.sayHello();

         Foo foo1 = () -> {System.out.println("hello world!!");};
         foo1.sayHello();

         Test test = (x, y) -> {
             System.out.println(x+"  "+y);
             return x+y;
         };

         test.add(1,2);
    }
}
