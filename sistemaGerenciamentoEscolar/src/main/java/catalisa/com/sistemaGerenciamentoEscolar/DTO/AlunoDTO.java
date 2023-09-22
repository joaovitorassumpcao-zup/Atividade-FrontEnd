package catalisa.com.sistemaGerenciamentoEscolar.DTO;

import catalisa.com.sistemaGerenciamentoEscolar.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoDTO implements Serializable {
    private static final long serialverionUID=1L;
    private String nome, email;
    private Integer idade;
    public AlunoDTO(Aluno aluno){
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.idade = aluno.getIdade();
    }
}
