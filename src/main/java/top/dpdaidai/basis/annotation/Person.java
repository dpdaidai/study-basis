package top.dpdaidai.basis.annontation;

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

    /**
     *
     * @param name
     * @return
     */
    public static Person build(String name) {
        return new Person(name);
    }

    public Person(String name) {
        this.setName(name);
    }

    @Override
    public String toString(){
        return null;
    }

}
