package top.dpdaidai.basis.lambda.stream;

import lombok.Data;

/**
 * @Author chenpantao
 * @Date 4/12/21 5:48 PM
 * @Version 1.0
 */
@Data
public class Person {
    private Integer id;
    private String name;
    private Integer age;

    public Person() {

    }

    public static Person build(String name) {
        return new Person(name);
    }

    public Person(String name) {
        this.setName(name);
    }

}
