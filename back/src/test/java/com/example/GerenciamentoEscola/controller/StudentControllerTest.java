package com.example.GerenciamentoEscola.controller;

import com.example.GerenciamentoEscola.model.StudentModel;
import com.example.GerenciamentoEscola.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(StudentController.class)
public class StudentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StudentService studentService;

  @DisplayName("Find all students")
  @Test
  public void testListStudents() throws Exception {
    // Criando uma lista de estudantes
    List<StudentModel> studentList = new ArrayList<>();
    StudentModel student1 = new StudentModel();
    student1.setName("student1");
    student1.setAge(25);
    student1.setEmail("student1@email.com");

    StudentModel student2 = new StudentModel();
    student2.setName("student2");
    student2.setAge(45);
    student2.setEmail("student2@email.com");

    studentList.add(student1);
    studentList.add(student2);

    // Mockando a lista para o service retornar
    Mockito.when(studentService.findAllStudents()).thenReturn(studentList);

    mockMvc.perform(get("/api/student"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$[0].name").value("student1"))
        .andExpect(jsonPath("$[0].email").value("student1@email.com"))
        .andExpect(jsonPath("$[1].name").value("student2"))
        .andExpect(jsonPath("$[1].email").value("student2@email.com"));

    Mockito.verify(studentService, times(1)).findAllStudents();
  }

  @DisplayName("Find student by ID")
  @Test
  public void testFindStudentById() throws Exception {
    StudentModel student = new StudentModel();
    student.setId(1L);
    student.setName("student");
    student.setAge(25);
    student.setEmail("student@email.com");

    Mockito.when(studentService.findOneStudent(student.getId())).thenReturn(Optional.of(student));

    mockMvc.perform(get("/api/student/{id}", 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.name").value("student"))
        .andExpect(jsonPath("$.email").value("student@email.com"));
  }

  @DisplayName("Find student when ID not found")
  @Test
  public void testFindStudentIdNotFound() throws Exception {
    mockMvc.perform(get("/api/student/{id}", 1L))
        .andExpect(status().isNotFound());
  }

  @DisplayName("Register new student")
  @Test
  public void testCreateStudent() throws Exception {
    StudentModel student = new StudentModel();
    student.setName("student");
    student.setAge(25);
    student.setEmail("student@email.com");

    Mockito.when(studentService.registerStudent(any())).thenReturn(student);

    mockMvc.perform(post("/api/student")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"student\", \"age\": \"25\", \"email\": \"student1@email.com\"}"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("student"))
        .andExpect(jsonPath("$.age").value(25))
        .andExpect(jsonPath("$.email").value("student@email.com"));
  }

  @DisplayName("Delete a student")
  @Test
  public void testDeleteStudent() throws Exception {
    // Mockando um estudante para o service entcontrar e deletar.
    when(studentService.findOneStudent(1L)).thenReturn(Optional.of(new StudentModel()));

    mockMvc.perform(delete("/api/student/{id}", 1L))
        .andExpect(status().isOk());
  }

  @DisplayName("Delete a student when ID not found")
  @Test
  public void testDeleteStudentNotFound() throws Exception {
    mockMvc.perform(delete("/api/student/{id}", 1L))
        .andExpect(status().isNotFound());
  }
}
