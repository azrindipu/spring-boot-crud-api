package com.crud.crud.service;

import com.crud.crud.model.StudentModel;
import com.crud.crud.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private StudentRepository studentRepository;

    public StudentModel createStudent(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }

    public StudentModel getStudentById(Integer id){
        return studentRepository.findAllById(id);
    }

    public StudentModel updateStudent(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }

    public void deleteStudentById(Integer id){
        studentRepository.deleteById(id);
    }
}
