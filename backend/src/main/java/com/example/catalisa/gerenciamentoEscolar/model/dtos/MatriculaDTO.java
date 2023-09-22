package com.example.catalisa.gerenciamentoEscolar.model.dtos;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.MatriculaModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter

public class MatriculaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate dataMatricula;
    private AlunoModel alunos;
    private Long alunosId;
    private CursoModel cursos;
    private Long cursosId;

    public MatriculaDTO(MatriculaModel matriculaModel) {
        this.id = matriculaModel.getId();
        this.dataMatricula = matriculaModel.getDataMatricula();
        this.alunos = matriculaModel.getAlunos();
        this.alunosId = matriculaModel.getAlunosId();
        this.cursos = matriculaModel.getCursos();
        this.cursosId = matriculaModel.getCursosId();
    }

    public MatriculaDTO() {
    }

    public MatriculaModel toMatriculaModel(){
        return new MatriculaModel(id, dataMatricula, alunos, alunosId, cursos, cursosId);
    }
}
