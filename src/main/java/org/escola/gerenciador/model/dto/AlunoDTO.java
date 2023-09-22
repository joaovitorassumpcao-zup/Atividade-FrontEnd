package org.escola.gerenciador.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link org.escola.gerenciador.model.entity.Aluno}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AlunoDTO(@NotNull @NotEmpty @NotBlank String nome, int idade,
                       @NotNull @Size(min = 5, max = 260) @Email @NotEmpty @NotBlank String email,
                       @NotNull MatriculaDTO matricula) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}