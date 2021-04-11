package top.dpdaidai.basis.jdbc.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author chenpantao
 * @Date 4/8/21 5:19 PM
 * @Version 1.0
 */
@Data
public class Person {

    private Integer id;

    public String name;

    public Integer age;

    private Date birthday;


    public Person() {

    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


}
