package com.mysqlspring.app.controller;

import com.mysqlspring.app.dto.StudentRequest;
import com.mysqlspring.app.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.saveUser(studentRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> fetchStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> fetchStudents() {
        return new ResponseEntity<>(studentService.getUsers(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.updateUser(id, studentRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
