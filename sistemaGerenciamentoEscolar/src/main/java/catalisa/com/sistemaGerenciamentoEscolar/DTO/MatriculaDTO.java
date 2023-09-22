package catalisa.com.sistemaGerenciamentoEscolar.DTO;

import catalisa.com.sistemaGerenciamentoEscolar.model.Aluno;
import catalisa.com.sistemaGerenciamentoEscolar.model.Curso;
import catalisa.com.sistemaGerenciamentoEscolar.model.Matricula;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatriculaDTO implements Serializable {
    private static final long serialVersionUID= 1L;
@Temporal(TemporalType.DATE)
    private Date dataMatricula;
private Aluno aluno;
private Curso curso;
public MatriculaDTO(Matricula matricula){
    this.dataMatricula = matricula.getDataMatricula();
    this.aluno = matricula.getAluno();
    this.curso = matricula.getCurso();
}
}
