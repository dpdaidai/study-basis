package top.dpdaidai.basis.lambda.demo2;

import java.util.ArrayList;

/**
 * @Author chenpantao
 * @Date 3/8/21 4:34 PM
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 14, 67));
        list.add(new Student("lisi", 13, 89));
        list.add(new Student("wangwu", 15, 97));
        list.add(new Student("maliu", 12, 63));
        list.add(new Student("zhaoqi", 17, 75));

        //查找年龄大于14得学生
        getByFilter(list, e -> e.getAge() > 14);
        System.out.println("--------------");

        //查找分数大于75得学生
        getByFilter(list, e -> e.getScore() > 75);
        System.out.println("--------------");

        //查找年龄大于14 且 分数大于75得学生
        getByFilter(list, e -> e.getAge() > 14 && e.getScore() > 75);


    }

    public static void getByFilter(ArrayList<Student> students, StudentFilter filter) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (filter.compare(student)) {
                list.add(student);
            }
        }
        printStudent(list);
    }

    public static void printStudent(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

}
