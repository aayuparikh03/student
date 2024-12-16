package com.example.service;

import com.example.entity.Student;
import com.example.exception.StudentNotFoundException;
import com.example.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> found=studentRepository.findById(id);
        Student student=null;
        if(found.isPresent())
        {
            student=found.get();
        }else {
            throw new StudentNotFoundException("Student with id: "+id+" not found");
        }
        return student;
    }
    @Transactional
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student update(int id, Student student) {
        Student matched=findById(id);
        if(matched!=null)
        {
            if(student.getName()!=null)
            {
                matched.setName(student.getName());
            }
        }
        if(matched==null)
        {
            throw new StudentNotFoundException("Student with id: "+id+" not found");
        }
        return studentRepository.save(matched);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
        Student matched=findById(id);
        studentRepository.deleteById(id);
    }


}
