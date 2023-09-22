package catalisa.com.sistemaGerenciamentoEscolar.service;

import catalisa.com.sistemaGerenciamentoEscolar.exceções.DataBaseException;
import catalisa.com.sistemaGerenciamentoEscolar.exceções.RecursoNaoEncontradoException;
import catalisa.com.sistemaGerenciamentoEscolar.model.Aluno;
import catalisa.com.sistemaGerenciamentoEscolar.model.Matricula;
import catalisa.com.sistemaGerenciamentoEscolar.model.Professor;
import catalisa.com.sistemaGerenciamentoEscolar.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;


    public List<Professor> listarTodosProfessores(){
        return  professorRepository.findAll();
    }
    public Professor buscarProfessoresPorId(Long id){
        Optional<Professor> professorOptional = professorRepository.findById(id);
        return professorOptional.orElseThrow(() -> new RecursoNaoEncontradoException("id não encontrado." + id));
    }

    public void deletarProfessoresPorId (Long id){
        try {


            if (professorRepository.existsById(id)) {
                professorRepository.deleteById(id);

            } else {
                throw new RecursoNaoEncontradoException("id não encontrado" + id);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException("a tabela não pode ser removida pois tem uma relação com outra!");
        }
    }

    public Professor cadastrarProfessor(Professor professor){


        return professorRepository.save(professor);
    }
    public Professor alterarCadastroProfessor(Long id, Professor professor){
        try {
             Professor professorAtualizado = professorRepository.getReferenceById(id);
            alterarDadosProfessor(professorAtualizado, professor);
            return professorRepository.save(professorAtualizado);
        } catch (EntityNotFoundException e){
            throw  new RecursoNaoEncontradoException("id não encontrado. " + id);
        }
    }
    private void alterarDadosProfessor(Professor professorAtualizado, Professor professor){
        professorAtualizado.setNome(professor.getNome());
professorAtualizado.setCurso(professor.getCurso());
   professorAtualizado.setIdade(professor.getIdade());
    }





}
