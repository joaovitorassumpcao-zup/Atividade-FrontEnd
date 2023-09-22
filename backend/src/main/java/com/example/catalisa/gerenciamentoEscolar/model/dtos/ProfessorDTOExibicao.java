package com.example.catalisa.gerenciamentoEscolar.model.dtos;

import com.example.catalisa.gerenciamentoEscolar.model.ProfessorModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class ProfessorDTOExibicao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeProfessor;
    private Long cursosId;

    public ProfessorDTOExibicao(ProfessorModel professorModel){
        this.id = professorModel.getId();
        this.nomeProfessor = professorModel.getNomeProfessor();
        this.cursosId = professorModel.getCursosId();
    }

}
