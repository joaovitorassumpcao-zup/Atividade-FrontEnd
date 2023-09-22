package com.example.catalisa.gerenciamentoEscolar.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TB_MATRICULAS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataMatricula;

    @OneToOne
    @JoinColumn(name = "alunosId", referencedColumnName = "id", insertable = false, updatable = false)
    private AlunoModel alunos;
    private Long alunosId;

    @OneToOne
    @JoinColumn(name = "cursosId", referencedColumnName = "id", insertable = false, updatable = false)
    private CursoModel cursos;
    private Long cursosId;
}
