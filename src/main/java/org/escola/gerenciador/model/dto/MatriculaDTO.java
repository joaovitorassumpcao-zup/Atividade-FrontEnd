package org.escola.gerenciador.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import org.escola.gerenciador.model.entity.Aluno;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * DTO for {@link org.escola.gerenciador.model.entity.Matricula}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MatriculaDTO(Timestamp dataMatricula, @NotNull Aluno aluno,
                           CursoDTO cursoDTO) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}