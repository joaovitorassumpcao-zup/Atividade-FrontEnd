package catalisa.com.sistemaGerenciamentoEscolar.service;

import catalisa.com.sistemaGerenciamentoEscolar.exceções.DataBaseException;
import catalisa.com.sistemaGerenciamentoEscolar.exceções.RecursoNaoEncontradoException;
import catalisa.com.sistemaGerenciamentoEscolar.model.Aluno;
import catalisa.com.sistemaGerenciamentoEscolar.model.Curso;
import catalisa.com.sistemaGerenciamentoEscolar.model.Matricula;
import catalisa.com.sistemaGerenciamentoEscolar.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;


    public List<Curso> listarTodosCursos(){
        return  cursoRepository.findAll();
    }
    public Curso buscarCursoPorId(Long id){
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        return cursoOptional.orElseThrow(() -> new RecursoNaoEncontradoException("id não encontrado." + id));
    }

    public Curso cadastrarCurso(Curso curso){


        return cursoRepository.save(curso);
    }

    public void deletarCursoPorId (Long id){
        try {


            if (cursoRepository.existsById(id)) {
                cursoRepository.deleteById(id);

            } else {
                throw new RecursoNaoEncontradoException("id não encontrado" + id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("a tabela não pode ser removida pois tem uma relação com outra!");
        }
    }


    public Curso alterarCadastroCurso(Long id, Curso curso){
        try {
            Curso cursoAtualizado = cursoRepository.getReferenceById(id);
            alterarDadosCurso(cursoAtualizado, curso);
            return  cursoRepository.save(cursoAtualizado);
        } catch (EntityNotFoundException e){
            throw  new RecursoNaoEncontradoException("id não encontrado. " + id);
        }

    }
    private void alterarDadosCurso(Curso cursoAtualizado, Curso curso) {
        cursoAtualizado.setNome(curso.getNome());
        cursoAtualizado.setCargaHoraria(curso.getCargaHoraria());
    }

}

