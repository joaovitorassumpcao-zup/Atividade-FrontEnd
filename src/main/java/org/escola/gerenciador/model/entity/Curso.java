package org.escola.gerenciador.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 5, nullable = false)
    private Integer cargaHoraria;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "matricula_id", nullable = false, unique = true)
    private Matricula matricula;

    @OneToOne(mappedBy = "curso", cascade = CascadeType.ALL)
    private Professor professor;

}