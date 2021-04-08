package top.dpdaidai.basis.jdbc.dao;

import top.dpdaidai.basis.jdbc.entity.Person;

import java.util.List;

public interface PersonDao {
    void insert(Person person);

    void delete(Person person);

    void update(Person person);

    List<Person> select();

    Person selectById(Integer id);
}
