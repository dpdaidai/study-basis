package top.dpdaidai.basis.lambda.demo4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 *
 * 对象方法引用
 *
 * @Author chenpantao
 * @Date 4/12/21 11:53 AM
 * @Version 1.0
 */
public class Test4 {

    public static void main(String[] args) {
        //1
        Too too = new Too();
        too.foo();

        //2
        Consumer<Too> c1 = e -> e.foo();
        c1.accept(new Too());

        //3
        Consumer<Too> c2 = Too::foo;
        c2.accept(new Too());

        //4
        BiConsumer<Too2, String> bc1 = (too2, string) -> too2.show(string);
        BiConsumer<Too2, String> bc2 = Too2::show;

        bc1.accept(new Too2(), "abc");
        bc2.accept(new Too2(), "abc");

        //5
        BiFunction<Exec, String, Integer> bf1 = (exec, string) -> exec.test(string);
        BiFunction<Exec, String, Integer> bf2 = Exec::test;

        System.out.println(bf1.apply(new Exec(), "abc"));
        System.out.println(bf2.apply(new Exec(), "abcd"));

    }


}

class Exec {
    public int test(String name) {
        return name.length();
    }

}

class Too {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("foo");
    }
}

class Too2 {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("foo---too2");
    }

    public void show(String str) {
        System.out.println("show ---too2" + str);
    }
}
