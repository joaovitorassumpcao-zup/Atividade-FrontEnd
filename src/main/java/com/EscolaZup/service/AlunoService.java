package com.EscolaZup.service;

import com.EscolaZup.model.Aluno;
import com.EscolaZup.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    //Método que cadastra aluno
    public Aluno cadastraAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    //Método que apaga aluno na DB
    public void deletar(Long id) {
        alunoRepository.deleteById(id);
    }

    //Método que lista todos alunos da DB
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

}
