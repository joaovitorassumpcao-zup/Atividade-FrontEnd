package com.example.GerenciamentoEscola.repository;

import com.example.GerenciamentoEscola.model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationModel, Long> {
}
