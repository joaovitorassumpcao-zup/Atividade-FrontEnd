package com.example.GerenciamentoEscola.controller;

import com.example.GerenciamentoEscola.dto.StudentDTO;
import com.example.GerenciamentoEscola.model.StudentModel;
import com.example.GerenciamentoEscola.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("api/student")
public class StudentController {
  @Autowired
  StudentService studentService;

  @PostMapping
  public StudentModel registerNewStudent(@Valid @RequestBody StudentModel studentModel) {
    return studentService.registerStudent(studentModel);
  }

  @GetMapping
  public List<StudentDTO> findAllStudents(){
    List<StudentModel> student = studentService.findAllStudents();
    List<StudentDTO> studentDTO = new ArrayList<>();

    for(StudentModel students: student) {
      StudentDTO dto = new StudentDTO();
      dto.setName(students.getName());
      dto.setEmail(students.getEmail());
      studentDTO.add(dto);
    }
    return studentDTO;
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> findStudantById(@PathVariable Long id) {
    Optional<StudentModel> optionalStudent = studentService.findOneStudent(id);
    if(optionalStudent.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não econtrado!");
    }
    return ResponseEntity.ok((optionalStudent.get()));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleteStudent(@PathVariable Long id){
    Optional<StudentModel> optionalStudent = studentService.findOneStudent(id);
    if(optionalStudent.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado!");
    }
    studentService.deleteStudent(id);
    return ResponseEntity.ok().build();
  }
}
