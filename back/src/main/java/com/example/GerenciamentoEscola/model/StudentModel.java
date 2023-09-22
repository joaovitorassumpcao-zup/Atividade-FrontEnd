package com.example.GerenciamentoEscola.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "tb_student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class StudentModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "O nome é obrigatório!!") // Verifica se o campo está preenchido como nulo ou vázio.
  @Length(min = 3, max = 50, message = "O nome deverá ter no máximo {max} caracteres") // Determina a
  private String name;

  @NotNull(message = "A idade é obrigatório!!")
  @Min(value = 6, message = "A idade deve ter no mímino 1 caractere!")
  @Max(value = 99, message = "A idade deve ter no máximo 2 caracteres!")
  private Integer age;

  @NotBlank(message = "O email é obrigatório!!")
  @Email(message = "Informe um email válido!!")
  private String email;

}
