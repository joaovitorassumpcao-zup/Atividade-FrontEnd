package com.example.catalisa.gerenciamentoEscolar.repository;

import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {
}
