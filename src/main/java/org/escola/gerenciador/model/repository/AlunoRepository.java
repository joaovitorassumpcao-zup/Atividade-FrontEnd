package org.escola.gerenciador.model.repository;

import org.escola.gerenciador.model.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}