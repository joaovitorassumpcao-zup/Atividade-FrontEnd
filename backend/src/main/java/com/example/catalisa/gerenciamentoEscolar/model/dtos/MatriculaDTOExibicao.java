package com.example.catalisa.gerenciamentoEscolar.model.dtos;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.MatriculaModel;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class MatriculaDTOExibicao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long alunosId;
    private Long cursosId;

    public MatriculaDTOExibicao (MatriculaModel matriculaModel){
        this.id = matriculaModel.getId();
        this.alunosId = matriculaModel.getAlunosId();
        this.cursosId = matriculaModel.getCursosId();
    }


}
