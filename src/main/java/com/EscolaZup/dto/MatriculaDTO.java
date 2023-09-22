package com.EscolaZup.dto;

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
    private Long alunoIdDto;
    private Long cursoIdDto;
    private LocalDate dataMatriculaDto;

}
