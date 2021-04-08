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

    private String name;

    private Integer age;

    private Date birthday;
}
