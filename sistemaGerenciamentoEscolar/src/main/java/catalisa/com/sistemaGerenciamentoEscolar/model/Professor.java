package catalisa.com.sistemaGerenciamentoEscolar.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Table(name = "tb_professor")
@Entity
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;

    @ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "curso_id")
    private Curso curso;

    private BigDecimal salario;

}
