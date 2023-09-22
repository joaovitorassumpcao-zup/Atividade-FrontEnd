package catalisa.com.sistemaGerenciamentoEscolar.service;

import catalisa.com.sistemaGerenciamentoEscolar.exceções.DataBaseException;
import catalisa.com.sistemaGerenciamentoEscolar.exceções.RecursoNaoEncontradoException;
import catalisa.com.sistemaGerenciamentoEscolar.model.Aluno;
import catalisa.com.sistemaGerenciamentoEscolar.model.Curso;
import catalisa.com.sistemaGerenciamentoEscolar.model.Matricula;
import catalisa.com.sistemaGerenciamentoEscolar.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    @Autowired
    MatriculaRepository matriculaRepository;


    public List<Matricula> listarTodasMatriculas(){
        return  matriculaRepository.findAll();
    }
    public Matricula buscarMatriculaPorId(Long id){
        Optional<Matricula> matriculaOptional = matriculaRepository.findById(id);
        return matriculaOptional.orElseThrow(() -> new RecursoNaoEncontradoException("id não encontrado." + id));
    }


    public void deletarMatriculaPorId (Long id){
        try {


            if (matriculaRepository.existsById(id)) {
                matriculaRepository.deleteById(id);

            } else {
                throw new RecursoNaoEncontradoException("id não encontrado" + id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("a tabela não pode ser removida pois tem uma relação com outra!");
        }
    }

    public Matricula cadastrarMatricula(Matricula matricula){


        return matriculaRepository.save(matricula);
    }
    public Matricula alterarCadastroMatricula(Long id, Matricula matricula){
        try {
            Matricula matriculaAtualizada = matriculaRepository.getReferenceById(id);
            alterarDadosMatricula(matriculaAtualizada, matricula);
            return matriculaRepository.save(matriculaAtualizada);
        } catch (EntityNotFoundException e){
            throw  new RecursoNaoEncontradoException("id não encontrado. " + id);
        }
        }
    private void alterarDadosMatricula(Matricula matriculaAtualizada, Matricula matricula){
        matriculaAtualizada.setDataMatricula(matricula.getDataMatricula());
   matriculaAtualizada.setAluno(matricula.getAluno());
   matriculaAtualizada.setCurso(matricula.getCurso());
    }







}
