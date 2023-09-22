package com.example.catalisa.gerenciamentoEscolar.service;

import com.example.catalisa.gerenciamentoEscolar.model.MatriculaModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.MatriculaDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.MatriculaDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    //MÉTODOS

   // atualizar matricula do aluno
    public MatriculaModel editarMatricula(Long id, Long cursosId){

        MatriculaModel matriculaModel = matriculaRepository.findById(id).orElse(null);

        if(matriculaModel != null){
            matriculaModel.setCursosId(cursosId);
            return matriculaRepository.save(matriculaModel);
        }
        return null;
    }

    //listar todos os cadastros
    public List<MatriculaDTOExibicao> exibirMatriculas(){

        List<MatriculaModel> matriculas = matriculaRepository.findAll();
        List<MatriculaDTOExibicao> matriculasDTOExibicao = new ArrayList<>();

        for(MatriculaModel matricula : matriculas){
            matriculasDTOExibicao.add(new MatriculaDTOExibicao(matricula));
        }
        return matriculasDTOExibicao;
    }

    // fazer um novo cadastro
    public MatriculaDTO fazerMatricula(MatriculaDTO matriculaDTO){
        MatriculaModel novaMatricula = matriculaRepository.save(matriculaDTO.toMatriculaModel());
        return new MatriculaDTO(novaMatricula);
    }


//    // deletar cadastro
    public void excluirMatricula(Long id){

        matriculaRepository.deleteById(id);
    }

}
