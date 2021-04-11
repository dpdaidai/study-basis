package top.dpdaidai.basis.jdbc.reflect;

import top.dpdaidai.basis.jdbc.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author chenpantao
 * @Date 4/11/21 11:24 AM
 * @Version 1.0
 */
public class ClassAPI {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //获取成员变量
        Class<?> studentClass = Class.forName("top.dpdaidai.basis.jdbc.entity.Student");

        // 获取成员变量 , 包含子类和父类 , 仅包含public修饰得变量
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getName());
            System.out.println(field.getType());      // 成员变量类型
            System.out.println(field.getModifiers());   // 访问修饰符
            System.out.println("-----------------");
        }

        System.out.println("================");

        //返回当前类得所有属性 , 不仅局限于public修饰符 , 但不包含父类得属性
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
            System.out.println(declaredField.getName());
            System.out.println(declaredField.getType());      // 成员变量类型
            System.out.println(declaredField.getModifiers());   // 访问修饰符
            System.out.println("-----------------");
        }


        System.out.println("================");


        //反射在一定程度上破坏了封装行
        Field address = studentClass.getDeclaredField("address");
        address.setAccessible(true);  // 将private得成员变量设置为可访问 , 并可设置属性

        System.out.println(address.getName());
        System.out.println(address.getModifiers());

        Student o = (Student) studentClass.newInstance();
        address.set(o, "温江");
        System.out.println(o);


        System.out.println("==================");

        //获取对象得普通方法 , 包含当前对象以及父类对象得所有公共方法
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
//            System.out.println(method.getName());
//            System.out.println(method.getReturnType());
//            System.out.println(method.getParameterTypes());
        }

        System.out.println("==================");

        //获取当前类中所有得方法 , 无论什么访问修饰符
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("==================");
        //利用反射调用方法
        Method add = studentClass.getDeclaredMethod("add", int.class, int.class);
        add.setAccessible(true);
        Object o1 = studentClass.newInstance();
        Object invoke = add.invoke(o1, 1, 3);
        System.out.println(invoke);

        System.out.println("==================");

        //获取共有得构造方法
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("-----------------");

        //获取所有得构造方法 , 无论私有还是公有
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        System.out.println("-----------------");

        //如果调用私有得构造方法
        Constructor<?> declaredConstructor = studentClass.getDeclaredConstructor(String.class, Integer.class, String.class);
        declaredConstructor.setAccessible(true);
        Object o2 = declaredConstructor.newInstance("cpt", 13, "A");
        System.out.println(o2);


    }


}
