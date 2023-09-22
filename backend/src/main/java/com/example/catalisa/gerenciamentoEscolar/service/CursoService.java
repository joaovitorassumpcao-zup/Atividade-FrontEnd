package com.example.catalisa.gerenciamentoEscolar.service;

import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.CursoDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.CursoDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    //MÉTODOS

    //listar todos os cadastros
    public List<CursoDTOExibicao> exibirCursos(){

        List<CursoModel> cursos = cursoRepository.findAll();
        List<CursoDTOExibicao> cursosDTOexibicao = new ArrayList<>();

        for(CursoModel curso: cursos){
            cursosDTOexibicao.add(new CursoDTOExibicao(curso));
        }
        return cursosDTOexibicao;
    }

    // fazer um novo cadastro

    public CursoDTO cadastrarCurso(CursoDTO cursoDTO){

        CursoModel novoCurso = cursoRepository.save(cursoDTO.toCursoModel());
        return new CursoDTO(novoCurso);
    }

    // deletar cadastro
    public void excluirCurso(Long id){
        cursoRepository.deleteById(id);
    }
}
