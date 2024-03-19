package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> listStudents();
    void saveStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}
