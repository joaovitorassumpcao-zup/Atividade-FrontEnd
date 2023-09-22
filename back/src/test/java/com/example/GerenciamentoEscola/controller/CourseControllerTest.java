package com.example.GerenciamentoEscola.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.GerenciamentoEscola.model.CourseModel;
import com.example.GerenciamentoEscola.service.CourseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CourseService courseService;

  @DisplayName("Find all courses")
  @Test
  public void testListCourses() throws Exception {
    List<CourseModel> courseList = new ArrayList<>();
    CourseModel course1 = new CourseModel();
    course1.setName("Java");
    course1.setWorkload("500 horas");

    CourseModel course2 = new CourseModel();
    course2.setName("Python");
    course2.setWorkload("600 horas");

    courseList.add(course1);
    courseList.add(course2);

    when(courseService.findAllCourses()).thenReturn(courseList);

    mockMvc.perform(get("/api/course"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$[0].name").value("Java"))
        .andExpect(jsonPath("$[0].workload").value("500 horas"))
        .andExpect(jsonPath("$[1].name").value("Python"))
        .andExpect(jsonPath("$[1].workload").value("600 horas"));

    Mockito.verify(courseService, Mockito.times(1)).findAllCourses();
  }

  @DisplayName("Find course by ID")
  @Test
  public void testFindCourseById() throws Exception {
    CourseModel course = new CourseModel();
    course.setId(1L);
    course.setName("Java");
    course.setWorkload("500 horas");

    when(courseService.findOneCourse(course.getId())).thenReturn(Optional.of(course));

    mockMvc.perform(get("/api/course/{id}", 1L))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.name").value("Java"))
        .andExpect(jsonPath("$.workload").value("500 horas"));
  }

  @DisplayName("Find cour when ID not found")
  @Test
  public void testFindCourseIdNotFound() throws Exception {
    mockMvc.perform(get("/api/course/{id}", 1L))
        .andExpect(status().isNotFound());
  }

  @DisplayName("Delete a course")
  @Test
  public void testDeleteCourse() throws Exception {
    when(courseService.findOneCourse(1L)).thenReturn(Optional.of(new CourseModel()));

    mockMvc.perform(delete("/api/course/{id}", 1L))
        .andExpect(status().isOk());
  }

  @DisplayName("Delete a course when ID not found")
  @Test
  public void testDeleteCourseIdNotFound() throws Exception {
    mockMvc.perform(delete("/api/course/{id}", 1L))
        .andExpect(status().isNotFound());
  }
}
