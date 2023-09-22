package catalisa.com.sistemaGerenciamentoEscolar.repository;

import catalisa.com.sistemaGerenciamentoEscolar.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
