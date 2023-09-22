package org.escola.gerenciador.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_professores")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 3, nullable = false)
    private Integer idade;

    @Column(nullable = false)
    private BigDecimal salario;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

}