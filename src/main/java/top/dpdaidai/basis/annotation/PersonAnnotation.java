package top.dpdaidai.basis.annotation;


import java.lang.annotation.*;

// Target用来声明当前注解用于什么地方 : 类 , 方法 , 属性
@Target({ElementType.METHOD, ElementType.TYPE})
// Retention 表示注解用于什么环境 : 源码 , 类 , 运行时环境
@Retention(RetentionPolicy.RUNTIME)
//Documented表示当前注解是否能够被继承
@Documented
//Inherited表示注解能否被继承
@Inherited
public @interface PersonAnnotation {
    //定义得方式看起来像是方法 , 但是实际上是使用注解时 , 填写得参数名称 , 默认名称是value
    //自定义注解中填写得所有方法 , 在使用时都需要添加值 . 可以有的方法使用default设置默认值
    String name();

    int age() default 1;

    int id();

    String[] likes();
}
