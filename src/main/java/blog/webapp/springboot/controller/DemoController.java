package blog.webapp.springboot.controller;

import blog.webapp.springboot.entity.Student;
import blog.webapp.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String saveStudent(@ModelAttribute Student student) {
        demoService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteStudentById(@PathVariable(name = "id") Integer id) {
        demoService.deleteStudentById(id);
        return "redirect:/";
    }

    @GetMapping("update/{id}")
    public String updateById(Model model, @PathVariable(name = "id") Integer id) {
        Student student = demoService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        demoService.updateStudent(student);
        return "redirect:/";
    }
}
