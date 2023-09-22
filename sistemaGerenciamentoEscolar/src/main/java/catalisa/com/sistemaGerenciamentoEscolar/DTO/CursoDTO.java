package catalisa.com.sistemaGerenciamentoEscolar.DTO;

import catalisa.com.sistemaGerenciamentoEscolar.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CursoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
private String nome;
private Integer cargaHoraria;
public CursoDTO(Curso curso){
    this.nome = curso.getNome();
    this.cargaHoraria = curso.getCargaHoraria();
}
}
