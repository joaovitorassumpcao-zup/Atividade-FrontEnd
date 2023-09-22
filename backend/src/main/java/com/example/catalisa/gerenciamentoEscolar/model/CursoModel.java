package com.example.catalisa.gerenciamentoEscolar.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_CURSOS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeCurso;

    @Column(length = 3, nullable = false)
    private int cargaHoraria;


}
