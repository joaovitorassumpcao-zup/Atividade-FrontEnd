package org.escola.gerenciador.model.dto;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import org.escola.gerenciador.model.enums.TipoUsuario;

import java.io.Serial;
import java.io.Serializable;

public record UsuarioDTO(@NotNull @NotEmpty @NotBlank String nome, @NotNull Integer idade,
                         @NotNull @Size(min = 5, max = 260) @Email @NotEmpty @NotBlank String email,
                         @NotNull @Enumerated TipoUsuario tipoUsuario) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
