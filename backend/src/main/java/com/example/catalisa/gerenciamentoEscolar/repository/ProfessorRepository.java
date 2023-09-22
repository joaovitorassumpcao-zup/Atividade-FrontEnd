package com.example.catalisa.gerenciamentoEscolar.repository;

import com.example.catalisa.gerenciamentoEscolar.model.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorModel, Long> {
}
