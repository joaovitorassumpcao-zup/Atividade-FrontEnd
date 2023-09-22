package com.example.GerenciamentoEscola.repository;

import com.example.GerenciamentoEscola.model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, Long> {
}
