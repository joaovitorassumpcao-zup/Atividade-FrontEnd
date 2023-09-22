package com.example.catalisa.gerenciamentoEscolar.service;

import com.example.catalisa.gerenciamentoEscolar.model.ProfessorModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.ProfessorDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.ProfessorDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    //MÉTODOS

    //listar todos os cadastros
    public List<ProfessorDTOExibicao> exibirProfessores(){
        List<ProfessorModel> professores = professorRepository.findAll();
        List<ProfessorDTOExibicao> professoresDTOExibicao = new ArrayList<>();

        for(ProfessorModel professor: professores){
            professoresDTOExibicao.add(new ProfessorDTOExibicao(professor));
        }
        return professoresDTOExibicao;
    }

    // fazer novo cadastro
    public ProfessorDTO cadastrarProfessor(ProfessorDTO professorDTO){
        ProfessorModel novoProfessor = professorRepository.save(professorDTO.toProfessorModel());
        return new ProfessorDTO(novoProfessor);
    }

    // deletar cadastro
    public void excluirProfessor(Long id){
        professorRepository.deleteById(id);
    }
}
