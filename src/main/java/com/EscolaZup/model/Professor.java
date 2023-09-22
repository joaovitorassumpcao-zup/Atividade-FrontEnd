package com.EscolaZup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_professor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String nome;

    @Column(nullable = false)
    private int idade;

    @ManyToOne
    @JoinColumn(name = "cursoid", referencedColumnName = "id", insertable = false, updatable = false)
    private Curso curso;
    private Long cursoid;

    @Column(nullable = false)
    private BigDecimal salario;
}
