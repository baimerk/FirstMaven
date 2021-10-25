package main.by.itransition.jdbs_connection;

import main.by.itransition.enteties.Student;
import main.by.itransition.repository.BaseRepository;
import main.by.itransition.repository.impl.StudentRepositoryImpl;
import main.by.itransition.service.BaseService;
import main.by.itransition.service.impl.StudentServiceImpl;

public class JdbcTestConnection {
    public static void main(String[] args) {

        String createTable = "create table students (id int primary key auto_increment, name varchar(20), l_name varchar(20), age int)"; // SQL запрос создать таблицу
        String insert = "insert students(name, age) values('Maksim', 30),('Kirill', 76)";
        String update = "update students set age = 30 where id =3";
        String delete = "delete from students where id = 3";

        //String update = "ALTER TABLE students ADD l_name varchar(20)";

        //JdbsConnection connection = new JdbsConnection();

        //try(Connection conn = connection.getConnection()){
            //Statement statement = conn.createStatement();
            //statement.executeUpdate(createTable);
            //int rows = statement.executeUpdate(update);
            //System.out.println(rows);
            //System.out.println(conn.getClientInfo());
        //} catch (SQLException throwables) {
        //    throwables.printStackTrace();
        //}

        JdbsConnection connection = new JdbsConnection();
        BaseRepository<Student> repository = new StudentRepositoryImpl(connection);
        BaseService<Student> service = new StudentServiceImpl(repository);
        Student student = new Student("Vladimir","Vikov");
        boolean isSaved = service.save(student); // метод записи (вставки Insert) в таблицу.
        //boolean isSaved = service.deleteById(9);
        //Student student = service.findById(6);
        System.out.println(service);

    }
}
