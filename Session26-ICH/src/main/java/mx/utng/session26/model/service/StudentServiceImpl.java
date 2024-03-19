package mx.utng.session26.model.service;

import mx.utng.session26.model.dao.IStudentDao;
import mx.utng.session26.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Transactional(readOnly = true)
    @Override
    public List<Student> listStudents() {
        return studentDao.listStudents();
    }

    @Transactional
    @Override
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Transactional(readOnly = true)
    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Transactional
    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteStudent(id);
    }
}
