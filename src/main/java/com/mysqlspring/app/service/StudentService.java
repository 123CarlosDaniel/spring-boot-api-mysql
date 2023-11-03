package com.mysqlspring.app.service;

import com.mysqlspring.app.dto.StudentRequest;
import com.mysqlspring.app.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveUser(StudentRequest studentRequest);

    Student getUserById(Long id);

    List<Student> getUsers();

    Student updateUser(Long id, StudentRequest studentRequest);

    void deleteUser(Long id);
}
