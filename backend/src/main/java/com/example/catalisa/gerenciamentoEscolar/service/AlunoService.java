package com.example.catalisa.gerenciamentoEscolar.service;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.AlunoDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.AlunoDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    //MÉTODOS

    //listar todos os cadastros
    public List<AlunoDTOExibicao> exibirAlunos(){

        List<AlunoModel> alunos = alunoRepository.findAll();
        List<AlunoDTOExibicao> alunosDTOExibicao = new ArrayList<>();

        for(AlunoModel aluno: alunos){
            alunosDTOExibicao.add(new AlunoDTOExibicao(aluno));
        }
        return alunosDTOExibicao;
    }

    // fazer um novo cadastro
    public AlunoDTO cadastrarAluno(AlunoDTO alunoDTO){

        AlunoModel novoAluno = alunoRepository.save(alunoDTO.toAlunoModel());
        return new AlunoDTO(novoAluno);
    }

    // deletar cadastro
    public void excluirAluno(Long id){
        alunoRepository.deleteById(id);
    }
}
