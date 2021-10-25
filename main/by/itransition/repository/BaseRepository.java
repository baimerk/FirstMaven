package main.by.itransition.repository;

import java.util.List;

public interface BaseRepository <T> {

    T findById(int id);
    List<T> findAll();
    boolean deleteById(int id);
    boolean update(T entity);
    boolean save(T entity);

    // Здесь ниже расположены запросы к БД SQL
    //private static final String INSERT = "INSERT INTO students (name, l_name) values(?, ?)";
    //private static final String DELETE = "DELETE FROM students where id=?";
    //private static final String SElECT_BY_ID = "SELECT * FROM students where id=?";
    //private static final String SELECT_ALL = "SELECT * FROM student";
    //private static final String UPDATE = "UPDATE students SET name=?, l_name=?, age=? where id=?";

}
