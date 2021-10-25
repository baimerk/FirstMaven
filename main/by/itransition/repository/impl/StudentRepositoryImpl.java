package main.by.itransition.repository.impl;

import main.by.itransition.enteties.Student;
import main.by.itransition.jdbs_connection.JdbsConnection;
import main.by.itransition.repository.BaseRepository;

import java.sql.*;
import java.util.List;

public class StudentRepositoryImpl implements BaseRepository<Student> {

    private static final String INSERT = "INSERT INTO students(name, l_name) values (?, ?)";
    private static final String DELETE = "DELETE FROM students where id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM students where id = ?";

    private JdbsConnection connection;
    public StudentRepositoryImpl(JdbsConnection connection){
        this.connection = connection;
    }

    @Override
    public Student findById(int id) {
        Student student = new Student();
        try(Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(SELECT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("name"));
                student.setLastName(resultSet.getString("l_name"));
                student.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        try(Connection conn = connection.getConnection();
        PreparedStatement statement = conn.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            return statement.executeUpdate() !=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Student entity) {
        return false;
    }

    @Override
    public boolean save(Student entity) { // далее мы делаем еще один пакет - он будет сервисным
        try(Connection conn = connection.getConnection();
            PreparedStatement statement = conn.prepareStatement(INSERT)) {
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            return statement.executeUpdate() !=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
