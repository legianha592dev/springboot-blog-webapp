package blog.webapp.springboot.service;

import blog.webapp.springboot.entity.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DemoService {
    private List<Student> listStudent = new LinkedList<>();
    private static Integer index = 1000;

    public List<Student> getAll() {
        return listStudent;
    }

    public void addStudent(Student student) {
        student.setId(index);
        index++;
        listStudent.add(student);
    }

    public void deleteStudentById(Integer id) {
        for (Student student : listStudent) {
            if (student.getId().equals(id)) {
                listStudent.remove(student);
                break;
            }
        }
    }

    public Student getStudentById(Integer id) {
        for (Student student : listStudent) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return new Student();
    }

    public void updateStudent(Student editedStudent) {
        for (Student student : listStudent) {
            if (student.getId().equals(editedStudent.getId())) {
                BeanUtils.copyProperties(editedStudent, student);
                break;
            }
        }
    }
}
