package top.dpdaidai.basis.jdbc.reflect;

import top.dpdaidai.basis.jdbc.entity.Person;

/**
 * @Author chenpantao
 * @Date 4/8/21 11:06 PM
 * @Version 1.0
 */
public class CreateClassObject {

    public static void main(String[] args) throws ClassNotFoundException {
        //1  通过Class.forName()来获取Class对象
        Class<?> personClass = Class.forName("top.dpdaidai.basis.jdbc.entity.Person");
//        System.out.println(personClass.getPackage());
//        System.out.println(personClass.getName());
//        System.out.println(personClass.getSimpleName());
//        System.out.println(personClass.getCanonicalName());
//        System.out.println(personClass);

        //2  通过类名.class来获取
        Class<Person> personClass1 = Person.class;

        //3  通过getClass()来获取 , 不推荐使用
        Class<? extends Person> aClass = new Person().getClass();

        //4  基本数据类型可以使用 .TYPE 得方式获取Class对象
        Class<Integer> type = Integer.TYPE;


        Class<Integer[]> aClass1 = Integer[].class;
        System.out.println(aClass1.getPackage());
        System.out.println(aClass1.getName());
        System.out.println(aClass1.getSimpleName());
        System.out.println(aClass1.getCanonicalName());
        System.out.println(aClass1);

    }

}
