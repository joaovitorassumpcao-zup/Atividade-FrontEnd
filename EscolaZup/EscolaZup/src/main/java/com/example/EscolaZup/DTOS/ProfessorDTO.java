package com.example.EscolaZup.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
    private String nome;
    private int idade;
    private double salario;
    private Long cursoId;
}
