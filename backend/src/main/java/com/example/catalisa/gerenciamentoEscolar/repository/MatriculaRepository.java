package com.example.catalisa.gerenciamentoEscolar.repository;

import com.example.catalisa.gerenciamentoEscolar.model.MatriculaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<MatriculaModel, Long> {
}
