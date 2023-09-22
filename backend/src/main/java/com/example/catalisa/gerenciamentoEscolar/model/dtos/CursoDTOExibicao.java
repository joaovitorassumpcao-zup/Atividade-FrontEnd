package com.example.catalisa.gerenciamentoEscolar.model.dtos;

import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class CursoDTOExibicao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeCurso;

    public CursoDTOExibicao(CursoModel cursoModel){
        this.id = cursoModel.getId();
        this.nomeCurso = cursoModel.getNomeCurso();
    }

}
