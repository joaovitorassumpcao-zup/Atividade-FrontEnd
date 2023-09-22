package com.example.GerenciamentoEscola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_teacher")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O nome é obrigatório!!")
  @Length(min = 3, max = 50, message = "O nome deverá ter no máximo {max} caracteres")
  private String name;

  @NotNull(message = "A idade é obrigatório!!")
  @Min(value = 1, message = "A idade deve ter no mímino 1 caractere!")
  @Max(value = 99, message = "A idade deve ter no máximo 2 caracteres!.")
  private Integer age;

  @ManyToOne
  @JoinColumn(name = "course_id")
  private CourseModel course;

  @Column(nullable = false)
  private Double wage;
}
