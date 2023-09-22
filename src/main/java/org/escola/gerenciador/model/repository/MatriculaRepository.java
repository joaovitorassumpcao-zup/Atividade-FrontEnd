package org.escola.gerenciador.model.repository;

import org.escola.gerenciador.model.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}