package com.EscolaZup.service;

import com.EscolaZup.model.Professor;
import com.EscolaZup.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    CursoService cursoService;

    //Médoto para cadastrar professor
    public Professor cadastrarProfessor(Professor professor) {
        Professor novoProfessor = new Professor();

        novoProfessor.setNome(professor.getNome());
        novoProfessor.setIdade(professor.getIdade());
        novoProfessor.setSalario(professor.getSalario());
        novoProfessor.setCurso(professor.getCurso());

        return professorRepository.save(professor);
    }

    //Método que apaga professor na DB
    public void deletar(Long id) {
        professorRepository.deleteById(id);
    }

    //Método que lista todos professores da DB
    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

}
