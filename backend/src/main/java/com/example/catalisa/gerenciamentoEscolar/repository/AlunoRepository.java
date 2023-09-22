package com.example.catalisa.gerenciamentoEscolar.repository;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {
}
