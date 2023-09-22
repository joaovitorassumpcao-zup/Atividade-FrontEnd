package com.example.GerenciamentoEscola.service;

import com.example.GerenciamentoEscola.model.TeacherModel;
import com.example.GerenciamentoEscola.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
  @Autowired
  TeacherRepository teacherRepository;

  public List<TeacherModel> findAllTeacher() {
    return teacherRepository.findAll();
  }

  public Optional<TeacherModel> findOneTeacher(Long id) {
    return teacherRepository.findById(id);
  }

  public TeacherModel registerTeacher(TeacherModel teacherModel) {
    return teacherRepository.save(teacherModel);
  }

  public void deleteTeacher(Long id) {
    teacherRepository.deleteById(id);
  }
}
