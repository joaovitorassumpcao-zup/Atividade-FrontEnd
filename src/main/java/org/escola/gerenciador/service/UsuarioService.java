package org.escola.gerenciador.service;

import org.escola.gerenciador.model.dto.UsuarioDTO;
import org.escola.gerenciador.model.enums.TipoUsuario;
import org.escola.gerenciador.model.repository.AlunoRepository;
import org.escola.gerenciador.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    ProfessorRepository professorRepository;

    public UsuarioDTO cadastrar(UsuarioDTO usuario) {
        if (usuario.tipoUsuario().equals(TipoUsuario.PROFESSOR)) {
            // TODO: 22/09/2023
        } else {
            // TODO: 22/09/2023
        }

        return null;
    }
}
