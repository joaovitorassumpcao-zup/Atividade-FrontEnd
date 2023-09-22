package com.example.GerenciamentoEscola.repository;

import com.example.GerenciamentoEscola.model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {
}
