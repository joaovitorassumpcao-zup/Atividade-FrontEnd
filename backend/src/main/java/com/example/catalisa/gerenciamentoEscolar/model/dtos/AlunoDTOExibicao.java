package com.example.catalisa.gerenciamentoEscolar.model.dtos;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class AlunoDTOExibicao implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeAluno;

    public AlunoDTOExibicao(AlunoModel alunoModel){
        this.id = alunoModel.getId();
        this.nomeAluno = alunoModel.getNomeAluno();
    }



}
