package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    List<Student> listStudent = new ArrayList<>();

    public List<Student> getAll() {
        return listStudent;
    }

    public void addStudent(Student student) {
        listStudent.add(student);
    }
}
