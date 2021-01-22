package com.mp.demo.controller;

import com.mp.demo.model.Student;
import com.mp.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

@Autowired
    StudentService studentService;

    @GetMapping("/")
    public String index(Model model,Student student) {
        model.addAttribute("students",studentService.findall());
        return "index";
    }

    @PostMapping("create")
    public String create(Student student) {
    studentService.createStudent(student);
        return "redirect:/";
    }

    @GetMapping("update")
    public String update(@RequestParam Long id,Model model, Student student) {
       model.addAttribute("student", studentService.findbyid(id));
        return "update";
    }

    @PostMapping("update")
    public String update(Student student) {
        studentService.updateStudent(student);
        return "redirect:/";
    }


    @GetMapping("delete")
    public String update(@RequestParam Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

}
