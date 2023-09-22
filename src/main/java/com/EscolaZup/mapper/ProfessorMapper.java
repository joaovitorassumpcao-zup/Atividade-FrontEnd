package com.EscolaZup.mapper;

import com.EscolaZup.dto.ProfessorDTO;
import com.EscolaZup.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public ProfessorDTO toDto(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();

        dto.setNomeDto(professor.getNome());
        dto.setIdadeDto(professor.getIdade());
        dto.setSalarioDto(professor.getSalario());
        dto.setCursoIdDto(professor.getCursoid());

        return dto;
    }
}
