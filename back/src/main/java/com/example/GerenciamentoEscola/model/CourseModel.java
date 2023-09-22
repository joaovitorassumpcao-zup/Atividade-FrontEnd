package com.example.GerenciamentoEscola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_course")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50, nullable = false)
  private String name;
  @Column(length = 20, nullable = false)
  private String workload;
}
