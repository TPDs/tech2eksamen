package com.mp.demo.service;

import com.mp.demo.Repository.StudentRepository;
import com.mp.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student findbyid(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isEmpty()) {
            throw new RuntimeException("Student ikke fundet");
        }
        return studentOptional.get();
    }
    public Set<Student> findall(){
        Set<Student> studentSet = new HashSet<>();
        for(Student student: studentRepository.findAll()) {
            studentSet.add(student);
        }
        return studentSet;
    }
    public void createStudent(Student student) { studentRepository.save(student);}
    public void updateStudent(Student student) { studentRepository.save(student);}
    public void deleteStudent(Long id) { studentRepository.deleteById(id);}

}
