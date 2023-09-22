package com.example.GerenciamentoEscola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_registration")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private LocalDate registrationDate;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private StudentModel student;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private CourseModel course;
}
