package com.example.EscolaZup.service;

import com.example.EscolaZup.DTOS.CursoDTO;
import com.example.EscolaZup.model.Curso;
import com.example.EscolaZup.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public Curso cadastrarCurso(CursoDTO cursoDTO) {
        Curso novoCurso = new Curso();
        novoCurso.setNome(cursoDTO.getNome());
        novoCurso.setCargaHoraria(cursoDTO.getCargaHoraria());
        return cursoRepository.save(novoCurso);
    }

    public List<Curso>listarCurso() {
        return cursoRepository.findAll();
    }

    public void deletarCurso(Long cursoId) {
        if (!cursoRepository.existsById(cursoId)) {
            throw new IllegalArgumentException("Curso não encontrado.");
        }
        cursoRepository.deleteById(cursoId);
    }

}
