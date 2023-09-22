package com.example.catalisa.gerenciamentoEscolar.model.dtos;

import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.ProfessorModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter

public class ProfessorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeProfessor;
    private int idadeProfessor;
    private double salario;
    private CursoModel cursos;
    private Long cursosId;


    public ProfessorDTO(ProfessorModel professorModel) {
        this.id = professorModel.getId();
        this.nomeProfessor = professorModel.getNomeProfessor();
        this.idadeProfessor = professorModel.getIdadeProfessor();
        this.salario = professorModel.getSalario();
        this.cursos = professorModel.getCursos();
        this.cursosId = professorModel.getCursosId();

    }

    public ProfessorDTO() {
    }

    public ProfessorModel toProfessorModel(){
        return new ProfessorModel(id, nomeProfessor, idadeProfessor, salario, cursos, cursosId);
    }
}
