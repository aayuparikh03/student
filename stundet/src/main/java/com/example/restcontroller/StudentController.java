package com.example.restcontroller;

import com.example.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentController {
    @GetMapping("/students")
    List<Student> getAllStudents()
    {
        List<Student> allStudents=new ArrayList<>();
        allStudents.add(new Student(1,"Aayu"));
        allStudents.add(new Student(2,"Aryan"));

        return allStudents;
    }
}
