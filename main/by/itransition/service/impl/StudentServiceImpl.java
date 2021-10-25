package main.by.itransition.service.impl;

import main.by.itransition.enteties.Student;
import main.by.itransition.repository.BaseRepository;
import main.by.itransition.service.BaseService;

import java.util.List;

public class StudentServiceImpl implements BaseService<Student> {

    private BaseRepository<Student> repository;

    public StudentServiceImpl(BaseRepository<Student> repository){
        this.repository = repository;
    }

    @Override
    public Student findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    @Override
    public boolean update(Student entity) {
        return false;
    }

    @Override
    public boolean save(Student entity) {
        return repository.save(entity);
    }
}
