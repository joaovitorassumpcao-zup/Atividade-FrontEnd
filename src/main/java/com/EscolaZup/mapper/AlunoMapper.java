package com.EscolaZup.mapper;

import com.EscolaZup.dto.AlunoDTO;
import com.EscolaZup.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public AlunoDTO toDto(Aluno aluno) {
        AlunoDTO dto = new AlunoDTO();

        dto.setNomeDto(aluno.getNome());
        dto.setIdadeDto(aluno.getIdade());
        dto.setEmailDto(aluno.getEmail());

        return dto;
    }
}
