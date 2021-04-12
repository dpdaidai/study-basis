package top.dpdaidai.basis.lambda.demo4;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 实例方法引用
 * @Author chenpantao
 * @Date 4/12/21 11:29 AM
 * @Version 1.0
 */
public class Test3 {

    public String put(){
        return "put...";
    }

    public void getSize(int size){
        System.out.println("size:"+size);
    }

    public String toUpperCase(String str){
        return  str.toUpperCase();
    }

    public static void main(String[] args) {
        //1
        Test3 test3 = new Test3();
        System.out.println(test3.put());

        //2
        Supplier<String> s1 = () -> new Test3().put();
        System.out.println(s1.get());

        //3
        Supplier<String> s2 = new Test3()::put;
        System.out.println(s2.get());

        //4
        Consumer<Integer> c1 = e -> new Test3().getSize(e);
        Consumer<Integer> c2 = new Test3()::getSize;
        Test3 test = new Test3();
        Consumer<Integer> c3 = test::getSize;

        c1.accept(123);
        c2.accept(123);
        c3.accept(123);

        //5
        Function<String, String> f1 = e -> new Test3().toUpperCase(e);
        Function<String, String> f2 = new Test3()::toUpperCase;

        System.out.println(f1.apply("abc"));
        System.out.println(f2.apply("abc"));


    }

}
