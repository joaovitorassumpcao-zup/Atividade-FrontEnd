package catalisa.com.sistemaGerenciamentoEscolar.repository;

import catalisa.com.sistemaGerenciamentoEscolar.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
