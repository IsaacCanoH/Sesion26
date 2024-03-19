package mx.utng.session26.model.dao;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import mx.utng.session26.model.entity.Student;
import java.util.List;

@Repository
public class StudentDaoImpl implements IStudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> listStudents() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public void saveStudent(Student student) {
        if (student.getId() != null && student.getId() > 0) {
            entityManager.merge(student);
        } else {
            entityManager.persist(student);
        }
    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}
