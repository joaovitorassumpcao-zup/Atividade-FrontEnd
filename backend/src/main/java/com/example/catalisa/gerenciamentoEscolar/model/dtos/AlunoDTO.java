package com.example.catalisa.gerenciamentoEscolar.model.dtos;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter

public class AlunoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nomeAluno;
    private int idadeAluno;
    private String email;

    public AlunoDTO(AlunoModel alunoModel) {
        this.id = alunoModel.getId();
        this.nomeAluno = alunoModel.getNomeAluno();
        this.idadeAluno = alunoModel.getIdadeAluno();
        this.email = alunoModel.getEmail();

    }
    public AlunoDTO() {
    }

    public AlunoModel toAlunoModel(){
        return new AlunoModel(id,nomeAluno,idadeAluno,email);
    }
}
