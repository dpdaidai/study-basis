package top.dpdaidai.basis.lambda.demo4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造方法引用
 * @Author chenpantao
 * @Date 4/12/21 1:53 PM
 * @Version 1.0
 */
public class Test5 {
    public static void main(String[] args) {
        //1
        Supplier<Person> s1 = () -> new Person();
        System.out.println(s1.get());

        //2
        Supplier<Person> s2 = Person::new;
        System.out.println(s2.get());

        //3
        Supplier<List> s3 = ArrayList::new;
        Supplier<Set> s4 = HashSet::new;
        Supplier<String> s5 = String::new;
        Supplier<Thread> s6 = Thread::new;

        //4
        Supplier<Account> s7 = Account::new;
        Function<Integer, Account> f1 = Account::new;
        Function<String, Account> f2 = Account::new;

        s7.get();
        f1.apply(123);
        f2.apply("nick");

    }
}


class Account {
    public Account() {
        System.out.println("调用无参构造方法");
    }

    public Account(int age) {
        System.out.println("age 参数构造" + age);
    }

    public Account(String str) {
        System.out.println("str 参数构造" + str);
    }
}

class Person {
    public Person() {
        System.out.println("调用无参的构造方法");
    }
}
