package com.example.GerenciamentoEscola.controller;

import com.example.GerenciamentoEscola.dto.TeacherDTO;
import com.example.GerenciamentoEscola.model.TeacherModel;
import com.example.GerenciamentoEscola.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("api/teacher")
public class TeacherController {
  @Autowired
  TeacherService teacherService;

  @PostMapping
  public TeacherModel registerNewTeacher(@RequestBody TeacherModel teacherModel){
    return teacherService.registerTeacher(teacherModel);
  }

  @GetMapping
  public List<TeacherDTO> findAllTeachers() {
    List<TeacherModel> teacher = teacherService.findAllTeacher();
    List<TeacherDTO> teacherDTO = new ArrayList<>();

    for(TeacherModel teachers: teacher) {
      TeacherDTO dto = new TeacherDTO();
      dto.setName(teachers.getName());
      dto.setCourse(teachers.getCourse());
      teacherDTO.add(dto);
    }
    return teacherDTO;
  }
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleteTeacher(@PathVariable Long id){
    Optional<TeacherModel> optionalTeacher = teacherService.findOneTeacher(id);
    if(optionalTeacher.isEmpty()){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado!");
    }
    teacherService.deleteTeacher(id);
    return null;
  }
}
