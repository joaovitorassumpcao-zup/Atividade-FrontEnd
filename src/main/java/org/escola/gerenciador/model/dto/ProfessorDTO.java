package org.escola.gerenciador.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link org.escola.gerenciador.model.entity.Professor}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProfessorDTO(@NotNull @NotEmpty @NotBlank String nome, @NotNull Integer idade,
                           @NotNull BigDecimal salario, CursoDTO cursoDTO) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}