package com.crud.crud.controller;

import com.crud.crud.dto.StudentDto;
import com.crud.crud.manager.StudentManager;
import com.crud.crud.utils.Constants;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentManager studentManager;

    @PostMapping(value = "/student")
    public ResponseEntity<JSONObject> createStudent(@RequestBody StudentDto studentDto){
        StudentDto result = null;
        try {
            result = studentManager.createStudent(studentDto);
        }catch (Exception e){
            e.printStackTrace();

        }
        JSONObject responseBody = new JSONObject();
        responseBody.put(Constants.RESPONSE_BODY_DATA, result);
        responseBody.put(Constants.RESPONSE_BODY_STATUS, HttpStatus.OK);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "/student")
    public ResponseEntity<JSONObject> getStudentById(@RequestParam(required = true) Integer id){
        StudentDto result = null;
        try {
            result = studentManager.getStudentById(id);
        }catch (Exception e){
            e.printStackTrace();

        }
        JSONObject responseBody = new JSONObject();
        responseBody.put(Constants.RESPONSE_BODY_DATA, result);
        responseBody.put(Constants.RESPONSE_BODY_STATUS, HttpStatus.OK);

        return ResponseEntity.ok(responseBody);
    }

    @PutMapping(value = "/student")
    public ResponseEntity<JSONObject> updateStudent(@RequestBody StudentDto studentDto){
        StudentDto result = null;
        try {
            result = studentManager.updateStudentById(studentDto);
        }catch (Exception e){
            e.printStackTrace();

        }
        JSONObject responseBody = new JSONObject();
        responseBody.put(Constants.RESPONSE_BODY_DATA, result);
        responseBody.put(Constants.RESPONSE_BODY_STATUS, HttpStatus.OK);

        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping(value = "/student")
    public ResponseEntity<JSONObject> deleteStudentById(@RequestParam(required = true) Integer id){
        try {
            studentManager.deleteStudentById(id);
        }catch (Exception e){
            e.printStackTrace();

        }
        JSONObject responseBody = new JSONObject();
        responseBody.put(Constants.RESPONSE_BODY_DATA, true);
        responseBody.put(Constants.RESPONSE_BODY_STATUS, HttpStatus.OK);

        return ResponseEntity.ok(responseBody);
    }
}
