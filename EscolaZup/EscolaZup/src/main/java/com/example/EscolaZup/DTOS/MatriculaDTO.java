package com.example.EscolaZup.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {
    private Long alunoId;
    private Long cursoId;
    private LocalDate dataMatricula;
}
