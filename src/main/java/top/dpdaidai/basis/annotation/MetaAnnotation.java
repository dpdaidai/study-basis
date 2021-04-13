package top.dpdaidai.basis.annontation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author chenpantao
 * @Date 4/12/21 9:51 PM
 * @Version 1.0
 */
@MyAnnotation
public class MetaAnnotation {



}

@Target({ElementType.METHOD,ElementType.TYPE})   // Target用来声明当前注解用于什么地方 : 类 , 方法 , 属性
@interface  MyAnnotation{

}
