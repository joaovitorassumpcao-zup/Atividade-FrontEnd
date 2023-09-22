package com.EscolaZup.service;

import com.EscolaZup.model.Curso;
import com.EscolaZup.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    //Método que cadastra um novo curso
    public Curso cadastraCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    //Método que busca curso na DB
    public Optional<Curso> buscaCursoId(Long id) {
        return cursoRepository.findById(id);
    }

    //Método que apaga curso na DB
    public void deletar(Long id) {
        cursoRepository.deleteById(id);
    }

    //Método que lista todos alunos da DB
    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }

}
