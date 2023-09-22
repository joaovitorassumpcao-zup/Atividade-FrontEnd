package com.example.GerenciamentoEscola.service;

import com.example.GerenciamentoEscola.model.CourseModel;
import com.example.GerenciamentoEscola.model.StudentModel;
import com.example.GerenciamentoEscola.repository.CourseRepository;
import com.example.GerenciamentoEscola.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
  @Autowired
  StudentRepository studentRepository;

  public List<StudentModel> findAllStudents() {
    return studentRepository.findAll();
  }

  public Optional<StudentModel> findOneStudent(Long id) {
    return studentRepository.findById(id);
  }

  public StudentModel registerStudent(StudentModel studentModel) {
    return studentRepository.save(studentModel);
  }

  public void deleteStudent(Long id) {
   studentRepository.deleteById(id);
  }

}
