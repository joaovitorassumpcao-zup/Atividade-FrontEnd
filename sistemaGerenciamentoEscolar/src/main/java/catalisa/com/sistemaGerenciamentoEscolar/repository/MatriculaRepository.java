package catalisa.com.sistemaGerenciamentoEscolar.repository;

import catalisa.com.sistemaGerenciamentoEscolar.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
