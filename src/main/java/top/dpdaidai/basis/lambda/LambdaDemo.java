package top.dpdaidai.basis.lambda;

import java.util.*;
import java.util.stream.Stream;

/**
 * Lambda表达式
 *
 * 1  函数式编程
 * 2  参数类型自动推断
 * 3  代码更加简洁
 *
 * 应用于任何有函数式接口 ( 只有一个抽象方法的接口为函数式接口 )的地方
 * 函数式接口 , 可使用 @FunctionalInterface 来标记
 *
 *
 * @Author chenpantao
 * @Date 3/5/21 8:48 PM
 * @Version 1.0
 */
public class LambdaDemo {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        Stream<int[]> stream = integers.stream().map(int[]::new);


        new Thread(()->{
            System.out.println("running");
        }).start();


        List<String> list = Arrays.asList("java", "c", "c++");

//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        });
//
//        for (String s : list) {
//            System.out.println(s);
//        }

        Collections.sort(list, Comparator.comparingInt(String::length));
        list.forEach(System.out::println);





    }
}
