package com.example.EscolaZup.service;

import com.example.EscolaZup.DTOS.ProfessorDTO;
import com.example.EscolaZup.model.Curso;
import com.example.EscolaZup.model.Professor;
import com.example.EscolaZup.repository.CursoRepository;
import com.example.EscolaZup.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    CursoRepository cursoRepository;

    public Professor cadastrarProfessor(ProfessorDTO professorDTO) {
        Professor novoProfessor = new Professor();
        novoProfessor.setNome(professorDTO.getNome());
        novoProfessor.setIdade(professorDTO.getIdade());
        novoProfessor.setSalario(professorDTO.getSalario());

        if (professorDTO.getCursoId() != null) {
            Optional<Curso> cursoOptional = cursoRepository.findById(professorDTO.getCursoId());
            if (cursoOptional.isPresent()) {
                Curso curso = cursoOptional.get();
                novoProfessor.setCurso(curso);
            }else {
                throw new IllegalArgumentException("Curso não encontrado pelo ID fornecido.");
            }
        }
        return professorRepository.save(novoProfessor);
    }

    public List<Professor>listarProfessor() {
        return professorRepository.findAll();
    }

    public void deletarProfessor(Long professorId) {
        if (!professorRepository.existsById(professorId)) {
            throw new IllegalArgumentException("Professor não encontrado.");
        }
        professorRepository.deleteById(professorId);
    }
}
