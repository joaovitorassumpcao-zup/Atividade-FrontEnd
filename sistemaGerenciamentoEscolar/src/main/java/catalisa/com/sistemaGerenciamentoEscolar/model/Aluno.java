package catalisa.com.sistemaGerenciamentoEscolar.model;



import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_alunos")
@Entity

public class Aluno {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String nome;
    private String email;

private Integer idade;
}
