package com.example.GerenciamentoEscola.controller;

import com.example.GerenciamentoEscola.model.CourseModel;
import com.example.GerenciamentoEscola.model.TeacherModel;
import com.example.GerenciamentoEscola.service.CourseService;
import com.example.GerenciamentoEscola.service.TeacherService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TeacherService teacherService;

  @MockBean
  private CourseService courseService;

  @DisplayName("Find all teachers")
  @Test
  public void testListTeachers() throws Exception {

    CourseModel course = new CourseModel();
    course.setId(1L);
    course.setName("inglês");
    course.setWorkload("400 horas");

    List<TeacherModel> teacherList = new ArrayList<>();
    TeacherModel teacher = new TeacherModel();
    teacher.setName("Professor");
    teacher.setAge(40);
    teacher.setCourse(course);
    teacher.setWage(5.000);

    teacherList.add(teacher);

    when(teacherService.findAllTeacher()).thenReturn(teacherList);

    mockMvc.perform(get("/api/teacher"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$[0].name").value("Professor"))
        .andExpect(jsonPath("$[0].course.id").value(1))
        .andExpect(jsonPath("$[0].course.name").value("inglês"))
        .andExpect(jsonPath("$[0].course.workload").value("400 horas"));

    Mockito.verify(teacherService, Mockito.times(1)).findAllTeacher();
  }

  @DisplayName("Register new teacher")
  @Test
  public void testCreateTeacher() throws Exception {
    CourseModel course = new CourseModel(1L, "inglês", "400 horas");
    TeacherModel teacher = new TeacherModel();
    teacher.setName("Professor");
    teacher.setAge(40);
    teacher.setCourse(course);
    teacher.setWage(5.000);

    when(teacherService.registerTeacher(any())).thenReturn(teacher);

    mockMvc.perform(post("/api/teacher")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"Professor\", \"age:\": \"40\", \"course\": { \"id\": \"1\", \"name\": " +
                "\"inglês\", \"workload\": \"400 horas\"},\"wage\": \"5.000\"}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Professor"))
        .andExpect(jsonPath("$.age").value(40))
        .andExpect(jsonPath("$.course.id").value(1))
        .andExpect(jsonPath("$.course.name").value("inglês"))
        .andExpect(jsonPath("$.course.workload").value("400 horas"))
        .andExpect(jsonPath("$.wage").value(5.000));
  }

  @DisplayName("Delete a teacher")
  @Test
  public void testDeleteTeacher() throws Exception {
    when(teacherService.findOneTeacher(1L)).thenReturn(Optional.of(new TeacherModel()));

    mockMvc.perform(delete("/api/teacher/{id}", 1L))
        .andExpect(status().isOk());
  }

  @DisplayName("Delete a teacher when ID not found")
  @Test
  public void testDeleteTeacherIdNotFoun() throws Exception {
    mockMvc.perform(delete("/api/teacher/{id}", 1L))
        .andExpect(status().isNotFound());
  }
}
