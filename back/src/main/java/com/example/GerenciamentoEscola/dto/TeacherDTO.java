package com.example.GerenciamentoEscola.dto;

import com.example.GerenciamentoEscola.model.CourseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherDTO {
  private String name;
  private CourseModel course;
}
