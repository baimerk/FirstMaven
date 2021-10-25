package main.by.itransition.repository;

import main.by.itransition.enteties.Student;

import java.util.List;

public interface StudentRepository<V> extends BaseRepository<Student>{
    List<Student> findAllOrderByCriteria (String field, String Order);
}
