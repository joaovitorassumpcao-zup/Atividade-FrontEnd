package catalisa.com.sistemaGerenciamentoEscolar.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_cursos")
@Entity
public class Curso {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int cargaHoraria;



}
