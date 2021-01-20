package com.mp.demo.controller;

import com.mp.demo.Repository.StudentRepository;
import com.mp.demo.Repository.SupervisorRepository;
import com.mp.demo.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentRestController {

    StudentRepository studentRepository;
    SupervisorRepository supervisorRepository;
    public StudentRestController(StudentRepository studentRepository,SupervisorRepository supervisorRepository) {
        this.supervisorRepository=supervisorRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public Iterable<Student> findall() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> findbyid(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.status(200).body(student);
        } else {
            return ResponseEntity.status(404).body(student);
        }
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/student", consumes = {"application/json"})
    public ResponseEntity<String> create(@RequestBody Student st) {
            Student _st = new Student(st.getName(), st.getEmail());
            _st.setSupervisor(st.getSupervisor());
            studentRepository.save(_st);


        return ResponseEntity.status(201).header("Location", "/student/" + st.getId()).body("{'msg': 'Post created'}");
    }


    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PutMapping(value = "/student", consumes = {"application/json"})
    public ResponseEntity<String> update(@RequestBody Student st) {
        Optional<Student> optionalStudent = studentRepository.findById(st.getId());
        if(optionalStudent.isEmpty()) {
            return ResponseEntity.status(404).body("{'msg'} :Not found ");

        }
        studentRepository.save(st);
        return ResponseEntity.status(200).body("{'msg'}: Update");


    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Student> stud = studentRepository.findById(id);
        if (stud.isEmpty()) {
            return ResponseEntity.status(404).body("{'msg'; Not found!}");
        }
       studentRepository.deleteById(id);
        return ResponseEntity.status(200).body("{'msg'}: Deleted");
    }


}
