package top.dpdaidai.basis.lambda.demo4;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * 静态方法引用
 * @Author chenpantao
 * @Date 4/12/21 11:02 AM
 * @Version 1.0
 */
public class Test2 {

    static String put() {
        System.out.println("put()...");
        return "put";
    }

    public static void getSize(int size) {
        System.out.println(size);
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static Integer getLength(String str, String str2) {
        return str.length() + str2.length();
    }

    public static void main(String[] args) {
        //1
        System.out.println(put());

        //2
        Supplier<String> supplier = () -> Test2.put();
        System.out.println(supplier.get());

        //3
        Supplier<String> s2 = Test2::put;
        System.out.println(s2.get());

        //4
        Consumer<Integer> c1 = Test2::getSize;
        c1.accept(123);

        //5
        Function<String, String> f1 = e -> e.toUpperCase();
        Function<String, String> f2 = e -> Test2.toUpperCase(e);
        Function<String, String> f3 = Test2::toUpperCase;
        System.out.println(f1.apply("a") + f2.apply("a") + f3.apply("a"));

        //6
        BiFunction<String, String, Integer> bf1 = (a, b) -> a.length() + b.length();
        BiFunction<String, String, Integer> bf2 = Test2::getLength;
        System.out.println(bf1.apply("abc", "dfe"));
        System.out.println(bf2.apply("efg", "hij"));

    }
}
