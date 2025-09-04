package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Student;
import net.javaguides.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("listStudent", demoService.getAll());
        return "home-page";
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(Model model, @ModelAttribute Student student) {
        List<Student> listStudent = demoService.getAll();
        listStudent.add(student);

        model.addAttribute("listStudent", demoService.getAll());
        return "home-page";
    }
}
