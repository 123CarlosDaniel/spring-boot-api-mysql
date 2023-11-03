package com.mysqlspring.app.service;

import com.mysqlspring.app.dto.StudentRequest;
import com.mysqlspring.app.entity.Student;
import com.mysqlspring.app.exception.DuplicateInstanceException;
import com.mysqlspring.app.exception.NotFoundException;
import com.mysqlspring.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveUser(StudentRequest studentRequest) {
        Optional<Student> foundStudent = studentRepository.findStudentByEmail(studentRequest.getEmail());
        if (foundStudent.isPresent()) {
            throw new DuplicateInstanceException("Email is already used");
        }
        Student student = Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .build();
        return studentRepository.save(student);
    }

    @Override
    public Student getUserById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new NotFoundException(String.format("User with id = %s not found", id));
        }
        return student;
    }

    @Override
    public List<Student> getUsers() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student updateUser(Long id, StudentRequest studentRequest) {
        Student foundUser = studentRepository.findById(id).orElse(null);
        if (foundUser == null) {
            throw new NotFoundException(String.format("User with id = %s not found", id));
        }
        foundUser.setName(studentRequest.getName());
        foundUser.setAge(studentRequest.getAge());
        foundUser.setEmail(studentRequest.getEmail());
        return studentRepository.save(foundUser);
    }

    @Override
    public void deleteUser(Long id) {
        Student foundUser = studentRepository.findById(id).orElse(null);
        if (foundUser == null) {
            throw new NotFoundException(String.format("User with id = %s not found", id));
        }
        studentRepository.delete(foundUser);
    }
}
