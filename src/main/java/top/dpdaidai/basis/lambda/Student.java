package top.dpdaidai.basis.lambda;

import lombok.Data;

/**
 * @Author chenpantao
 * @Date 3/8/21 4:33 PM
 * @Version 1.0
 */
@Data
public class Student {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {

    }
}
