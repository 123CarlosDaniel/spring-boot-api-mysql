package com.mysqlspring.app.repository;


import com.mysqlspring.app.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
}
