package com.crud.crud.manager;

import com.crud.crud.converter.StudentConverter;
import com.crud.crud.dto.StudentDto;
import com.crud.crud.model.StudentModel;
import com.crud.crud.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentManager {
    private static final Logger logger = LoggerFactory.getLogger(StudentManager.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentConverter studentConverter;

    public StudentDto createStudent(StudentDto studentDto){
        StudentModel studentModel = studentConverter.convertDtoToModel(studentDto);
        studentModel = studentService.createStudent(studentModel);
        return studentConverter.convertModelToDto(studentModel);
    }

    public StudentDto getStudentById(Integer id){
        StudentModel studentModel = studentService.getStudentById(id);
        return studentConverter.convertModelToDto(studentModel);
    }

    public StudentDto updateStudentById(StudentDto studentDto){
        StudentModel studentModel = studentConverter.convertDtoToModel(studentDto);
        studentModel = studentService.updateStudent(studentModel);
        return studentConverter.convertModelToDto(studentModel);
    }

    public void deleteStudentById(Integer id){
        studentService.deleteStudentById(id);
    }
}
