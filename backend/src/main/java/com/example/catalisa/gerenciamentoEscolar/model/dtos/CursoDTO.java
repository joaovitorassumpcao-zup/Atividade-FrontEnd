package com.example.catalisa.gerenciamentoEscolar.model.dtos;

import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CursoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeCurso;
    private int cargaHoraria;

    public CursoDTO(CursoModel cursoModel) {
        this.id = cursoModel.getId();
        this.nomeCurso = cursoModel.getNomeCurso();
        this.cargaHoraria = cursoModel.getCargaHoraria();
    }
    public CursoDTO() {
    }

    public CursoModel toCursoModel(){
        return new CursoModel(id, nomeCurso, cargaHoraria);
    }

}
