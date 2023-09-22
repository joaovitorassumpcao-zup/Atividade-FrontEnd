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
public record AlunoDTO(@NotNull MatriculaDTO matricula,
                       @NotNull UsuarioDTO usuarioDTO) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}