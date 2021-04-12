package top.dpdaidai.basis.lambda.demo4;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @Author chenpantao
 * @Date 4/12/21 10:58 AM
 * @Version 1.0
 */
public class Test1 {

    public static void main(String[] args) {

        Function<String, Integer> function = e -> e.length();
        System.out.println(function.apply("abc"));

        Consumer<String> consumer = e -> System.out.println(e);
        consumer.accept("abc");


    }

}
