package com.EscolaZup.mapper;

import com.EscolaZup.dto.CursoDTO;
import com.EscolaZup.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public CursoDTO toDto(Curso curso) {
        CursoDTO dto = new CursoDTO();

        dto.setNomeDto(curso.getNome());
        dto.setCargahorariaDto(curso.getCargahoraria());

        return dto;
    }

}
