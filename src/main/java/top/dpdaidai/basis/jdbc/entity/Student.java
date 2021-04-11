package top.dpdaidai.basis.jdbc.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @Author chenpantao
 * @Date 4/11/21 11:30 AM
 * @Version 1.0
 */

@Data
@ToString(callSuper = true)  //toString 是否打印父类属性
public class Student extends Person {

    public String className;

    private String address;

    private Double score;

    private Student(String name, Integer age, String className) {
        super();
        this.name = name;
        this.age = age;
        this.className = className;
    }


    public Student() {
        super();
    }

    public Student(String name, Integer age, String className, String address) {
        super(name, age);
        this.className = className;
        this.address = address;
    }

    private int add(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }

}
