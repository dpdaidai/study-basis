package top.dpdaidai.basis.annotation;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * https://zhuanlan.zhihu.com/p/27643133
 *
 * @Author chenpantao
 * @Date 4/12/21 9:51 PM
 * @Version 1.0
 */

public class MetaAnnotation {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> personClass = Class.forName("top.dpdaidai.basis.annotation.Person");

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            System.out.println(annotation.annotationType());
        }

        //注解存在Runtime时可以这样获取
        PersonAnnotation annotation = personClass.getAnnotation(PersonAnnotation.class);
        System.out.println(annotation);
        System.out.println(annotation.id());
        Arrays.stream(annotation.likes()).forEach(System.out::println);
        System.out.println(annotation.name());
        System.out.println(annotation.age());



    }

}


