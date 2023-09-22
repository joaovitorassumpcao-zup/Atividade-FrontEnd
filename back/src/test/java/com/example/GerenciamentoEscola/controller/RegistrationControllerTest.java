package com.example.GerenciamentoEscola.controller;

import com.example.GerenciamentoEscola.model.CourseModel;
import com.example.GerenciamentoEscola.model.RegistrationModel;
import com.example.GerenciamentoEscola.model.StudentModel;
import com.example.GerenciamentoEscola.service.RegistrationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @MockBean
  RegistrationService registrationService;

  @DisplayName("Find all registration")
  @Test
  public void testListAllRegistrations() throws Exception {
    List<RegistrationModel> registrationList = new ArrayList<>();
    CourseModel course = new CourseModel(1L, "inglês", "400 horas");
    StudentModel student = new StudentModel(1L, "student", 25, "student@email.com");

    RegistrationModel registration = new RegistrationModel();
    registration.setRegistrationDate(LocalDate.now());
    registration.setStudent(student);
    registration.setCourse(course);
    registrationList.add(registration);

    when(registrationService.findAllRegistrations()).thenReturn(registrationList);

    mockMvc.perform(get("/api/registration"))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$[0].registrationDate").value(LocalDate.now().toString()))
        .andExpect(jsonPath("$[0].student.id").value(1L))
        .andExpect(jsonPath("$[0].student.name").value("student"))
        .andExpect(jsonPath("$[0].student.age").value(25))
        .andExpect(jsonPath("$[0].student.email").value("student@email.com"))
        .andExpect(jsonPath("$[0].course.id").value(1L))
        .andExpect(jsonPath("$[0].course.name").value("inglês"))
        .andExpect(jsonPath("$[0].course.workload").value("400 horas"));
  }

}
