package com.example.restcontroller;

import com.example.dto.StudentErrorResponse;
import com.example.entity.Student;
import com.example.exception.StudentNotFoundException;
import com.example.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    List<Student> getAllStudents()
    {
        return studentService.findAll();
    }
    @GetMapping("/students/{id}")
    Student getStudentById(@PathVariable int id)
    {
        return studentService.findById(id);
    }
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.save(student);
    }
    @PatchMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student,@PathVariable int id)
    {
        return studentService.update(id,student);
    }
    @DeleteMapping("/students/{id}")
    public String deleteById(@PathVariable int id)
    {
        studentService.deleteById(id);

        return "Student with id: "+id+" is deleted";
    }
}
