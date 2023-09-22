package catalisa.com.sistemaGerenciamentoEscolar.DTO;

import catalisa.com.sistemaGerenciamentoEscolar.model.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfessorDTO implements Serializable {
   private static final long serialVersionUID = 1L;
    private String nome;
    private Integer idade;
    private BigDecimal salario;
    public ProfessorDTO(Professor professor){
        this.nome = professor.getNome();
        this.idade = professor.getIdade();
        this.salario = professor.getSalario();
    }
}
