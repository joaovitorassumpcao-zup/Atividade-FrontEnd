package catalisa.com.sistemaGerenciamentoEscolar.service;

import catalisa.com.sistemaGerenciamentoEscolar.exceções.DataBaseException;
import catalisa.com.sistemaGerenciamentoEscolar.exceções.RecursoNaoEncontradoException;
import catalisa.com.sistemaGerenciamentoEscolar.model.Aluno;
import catalisa.com.sistemaGerenciamentoEscolar.model.Matricula;
import catalisa.com.sistemaGerenciamentoEscolar.repository.AlunoRepository;
import catalisa.com.sistemaGerenciamentoEscolar.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
@Autowired
    private AlunoRepository alunoRepository;

 public List<Aluno> listarTodosAlunos(){
     return  alunoRepository.findAll();
 }
public Aluno buscarAlunoPorId(Long id){
     Optional<Aluno> alunoOptional = alunoRepository.findById(id);
     return alunoOptional.orElseThrow(() -> new RecursoNaoEncontradoException("id não encontrado." + id));
}


public Aluno cadastrarAluno(Aluno aluno){
     return alunoRepository.save(aluno);
}

    public void deletarAlunoPorId (Long id){
        try {


            if (alunoRepository.existsById(id)) {
                alunoRepository.deleteById(id);

            } else {
                throw new RecursoNaoEncontradoException("id não encontrado" + id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("a tabela não pode ser removida pois tem uma relação com outra!");
        }
    }


public Aluno alterarCadastroAluno(Long id, Aluno aluno) {
    try {
        Aluno alunoAtualizado = alunoRepository.getReferenceById(id);
        alterarDadosAluno(alunoAtualizado, aluno);
        return alunoRepository.save(alunoAtualizado);
    } catch (EntityNotFoundException e) {
        throw new RecursoNaoEncontradoException(id);
    }
}
 private void alterarDadosAluno(Aluno alunoAtualizado, Aluno aluno){

alunoAtualizado.setNome(aluno.getNome());
alunoAtualizado.setEmail(aluno.getEmail());
alunoAtualizado.setIdade(aluno.getIdade());
}



     }


