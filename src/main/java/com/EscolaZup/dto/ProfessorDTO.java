package com.EscolaZup.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
    private String nomeDto;
    private int idadeDto;
    private Long cursoIdDto;
    private BigDecimal salarioDto;
}
