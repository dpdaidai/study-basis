package top.dpdaidai.basis.lambda.demo3;

import top.dpdaidai.basis.lambda.demo2.Student;

import java.util.concurrent.Callable;
import java.util.function.*;

/**
 * @Author chenpantao
 * @Date 4/11/21 6:23 PM
 * @Version 1.0
 */
public class LambdaTest {

    public static void main(String[] args) throws Exception {

        //1  匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running 1 ..");

            }
        };
        runnable.run();

        //2  lambda
        Runnable runnable1 = () -> {
            System.out.println("running 2...");
        };
        runnable1.run();

        //3  lambda 单行代码省略 大括号
        Runnable runnable2 = () -> System.out.println("running 3 ...");
        runnable2.run();

        //4  有返回值得内部类
        Callable<String> c1 = new Callable() {
            @Override
            public String call() throws Exception {

                return "c1";
            }
        };
        System.out.println(c1.call());

        //5  lambda有返回值
        Callable<String> c2 = () -> {
            return "c2";
        };
        System.out.println(c2.call());

        //6  lambda有返回值时省略 return
        Callable<String> c3 = () -> "c3";
        System.out.println(c3.call());

        //自定义函数式接口
        StudentDao sd1 = new StudentDao() {
            @Override
            public void insert(Student student) {
                System.out.println("插入学生1" + student);

            }
        };

        StudentDao sd2 = (student) -> {
            System.out.println("插入学生2" + student);
        };

        StudentDao sd3 = (student) -> System.out.println("插入学生3" + student);


        TeacherDao td1 = new TeacherDao() {
            @Override
            public int get(Teacher teacher) {
                return 1;
            }

        };

        TeacherDao td2 = teacher -> {
            return 2;
        };


        TeacherDao td3 = (Teacher teacher) -> 3;

        TeacherDao td4 = teacher -> 4;

        //可以调用有返回值得函数 , 但不能直接返回确定得值
        Runnable runnable3 = () -> get();
        runnable3.run();

        LambdaInterface lambdaInterface = () -> get();

        LambdaInterface lambdaInterface1 = () -> 100;

        //定义Function接口  , 输入必须时String, 输出必须是Integer
        Function<String, Integer> f1 = string -> {
            return string.length();
        };
        System.out.println(f1.apply("liziqiang"));

        //定义BiFunction接口
        BiFunction<String, String, Integer> bf = (a, b) -> a.length() + b.length();
        Integer apply = bf.apply("nihao", "wohao");
        System.out.println(apply);

        //定义Supplier
        Supplier<String> s = () -> "s";
        System.out.println(s.get());

        //定义Consumer
        Consumer<String> c = (a) -> System.out.println(a.length());
        c.accept("nihao");

        //定义UnaryOperator
        UnaryOperator<String> unaryOperator = (a) -> a.length() + "";
        System.out.println(unaryOperator.apply("nihaoaaa"));

        //定义BinaryOperator
        BinaryOperator<String> binaryOperator = (a, b) -> a.length() + "," + b.length();
        System.out.println(binaryOperator.apply("nihao", "shime"));


    }
    static int get(){
        return 1;
    }

    static String find(){
        return "find";
    }

    static void exec(){
        find();
    }

}
