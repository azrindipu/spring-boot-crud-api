package com.crud.crud.converter;

import com.crud.crud.dto.StudentDto;
import com.crud.crud.model.StudentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    private static final Logger logger = LoggerFactory.getLogger(StudentConverter.class);

    public StudentDto convertModelToDto(StudentModel studentModel){
        return StudentDto
                .builder()
                .id(studentModel.getId())
                .name(studentModel.getStudentName())
                .roll(studentModel.getStudentRoll())
                .build();

    }

    public StudentModel convertDtoToModel(StudentDto studentDto){
        return StudentModel
                .builder()
                .id(studentDto.getId())
                .studentName(studentDto.getName())
                .studentRoll(studentDto.getRoll())
                .build();
    }
}
