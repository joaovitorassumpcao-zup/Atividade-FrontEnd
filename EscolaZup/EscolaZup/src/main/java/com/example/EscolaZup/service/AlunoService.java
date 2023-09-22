package com.example.EscolaZup.service;

import com.example.EscolaZup.DTOS.AlunoDTO;
import com.example.EscolaZup.model.Aluno;
import com.example.EscolaZup.model.Curso;
import com.example.EscolaZup.repository.AlunoRepository;
import com.example.EscolaZup.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    CursoRepository cursoRepository;

    public Aluno cadastrarAluno(AlunoDTO alunoDTO) {
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(alunoDTO.getNome());
        novoAluno.setIdade(alunoDTO.getIdade());
        novoAluno.setEmail(alunoDTO.getEmail());
        return alunoRepository.save(novoAluno);
    }

    public List<Aluno>listarAluno() {
        return alunoRepository.findAll();
    }

    public void atualizarCursoDoAluno(Long alunoId, Long novoCursoId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        Optional<Curso> novoCursoOptional = cursoRepository.findById(novoCursoId);

        if (alunoOptional.isPresent() && novoCursoOptional.isPresent()){
            Aluno aluno = alunoOptional.get();
            Curso novoCurso = novoCursoOptional.get();

            aluno.setCurso(novoCurso);
            alunoRepository.save(aluno);
        }else {
            throw new IllegalArgumentException("Aluno ou curso não encontrado.");
        }
    }

    public void deletarAluno(Long alunoId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            alunoRepository.delete(aluno);
        }else {
            throw new IllegalArgumentException("Aluno não encontrado");
        }
    }
}
