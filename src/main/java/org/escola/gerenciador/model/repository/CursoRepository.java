package org.escola.gerenciador.model.repository;

import org.escola.gerenciador.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}