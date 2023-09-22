package com.example.EscolaZup.service;

import com.example.EscolaZup.DTOS.MatriculaDTO;
import com.example.EscolaZup.model.Aluno;
import com.example.EscolaZup.model.Curso;
import com.example.EscolaZup.model.Matricula;
import com.example.EscolaZup.repository.AlunoRepository;
import com.example.EscolaZup.repository.CursoRepository;
import com.example.EscolaZup.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    CursoRepository cursoRepository;

    public Matricula fazerMatricula(MatriculaDTO matriculaDTO) {
        Matricula novaMatricula = new Matricula();

        Optional<Aluno> alunoOptional = alunoRepository.findById(matriculaDTO.getAlunoId());
        Optional<Curso> cursoOptional = cursoRepository.findById(matriculaDTO.getCursoId());

        if (alunoOptional.isPresent() && cursoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            Curso curso = cursoOptional.get();

            novaMatricula.setAluno(aluno);
            novaMatricula.setCurso(curso);
            novaMatricula.setDataMatricula(matriculaDTO.getDataMatricula());

            return matriculaRepository.save(novaMatricula);
        } else {
            throw new IllegalArgumentException("Aluno ou curso não encontrado");
        }
    }
}


