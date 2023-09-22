package org.escola.gerenciador.model.repository;

import org.escola.gerenciador.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}