package org.escola.gerenciador.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

/**
 * DTO for {@link org.escola.gerenciador.model.entity.Curso}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record CursoDTO(@NotNull @NotEmpty @NotBlank String nome, @NotNull Integer cargaHoraria,
                       MatriculaDTO matricula, ProfessorDTO professor) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}