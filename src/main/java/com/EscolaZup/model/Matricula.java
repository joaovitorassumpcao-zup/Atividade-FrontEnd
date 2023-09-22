package com.EscolaZup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_matricula")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate datamatricula;

    @ManyToOne
    @JoinColumn(name = "alunoid", referencedColumnName = "id", insertable = false, updatable = false)
    private Aluno aluno;
    private Long alunoid;

    @ManyToOne
    @JoinColumn(name = "cursoid", referencedColumnName = "id", insertable = false, updatable = false)
    private Curso curso;
    private Long cursoid;
}
