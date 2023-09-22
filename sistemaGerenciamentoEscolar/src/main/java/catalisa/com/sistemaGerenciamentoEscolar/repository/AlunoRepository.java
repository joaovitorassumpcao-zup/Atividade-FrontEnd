package catalisa.com.sistemaGerenciamentoEscolar.repository;

import catalisa.com.sistemaGerenciamentoEscolar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
