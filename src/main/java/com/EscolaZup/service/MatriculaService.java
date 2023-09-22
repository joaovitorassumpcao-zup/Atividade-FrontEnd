package com.EscolaZup.service;

import com.EscolaZup.model.Matricula;
import com.EscolaZup.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;


    //Método que cadastra matrícula
    public Matricula cadastraMatricula(Matricula matricula) {
        LocalDate dataMatricula = LocalDate.now();
        matricula.setDatamatricula(dataMatricula);

        return matriculaRepository.save(matricula);
    }

    //Método que atualiza curso do ano
    public Matricula atualizaCurso(Matricula matricula) {
        Optional<Matricula> novoCurso = buscaAlunoId(matricula.getAlunoid());


        if (novoCurso.isPresent()) {
            Matricula atualizaCursoAluno = novoCurso.get();
            atualizaCursoAluno.setCursoid(matricula.getCursoid());
            atualizaCursoAluno.setDatamatricula(matricula.getDatamatricula());
            return matriculaRepository.save(atualizaCursoAluno);

        } else {
            System.out.print("Aluno não encontrado");
            return null;
        }
    }

    //Método que pesquisa por aluno na base
    public Optional<Matricula> buscaAlunoId(Long alunoid) {
        return matriculaRepository.findById(alunoid);
    }
}
