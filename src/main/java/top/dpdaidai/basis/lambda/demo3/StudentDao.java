package top.dpdaidai.basis.lambda.demo3;

import top.dpdaidai.basis.lambda.demo2.Student;


@FunctionalInterface
public interface StudentDao {

    void insert(Student student);

}
