package com.example.catalisa.gerenciamentoEscolar.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_PROFESSORES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeProfessor;

    @Column(length = 2, nullable = false)
    private int idadeProfessor;

    @Column(nullable = false)
    private double salario;

    @OneToOne
    @JoinColumn(name = "cursosId", referencedColumnName = "id", insertable = false, updatable = false)
    private CursoModel cursos;
    private Long cursosId;

}
