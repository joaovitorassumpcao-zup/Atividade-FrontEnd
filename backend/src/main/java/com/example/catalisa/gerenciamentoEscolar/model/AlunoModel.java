package com.example.catalisa.gerenciamentoEscolar.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_ALUNOS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nomeAluno;

    @Column(length = 2, nullable = false)
    private int idadeAluno;

    @Column(length = 200, nullable = false)
    private String Email;

}
