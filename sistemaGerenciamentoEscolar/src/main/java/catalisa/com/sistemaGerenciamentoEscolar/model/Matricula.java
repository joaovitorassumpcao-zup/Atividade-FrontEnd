package catalisa.com.sistemaGerenciamentoEscolar.model;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "tb_matriculas")
@Entity
@Data
public class Matricula {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Temporal(TemporalType.DATE)
    private Date dataMatricula;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id")
    private Curso curso;

}
