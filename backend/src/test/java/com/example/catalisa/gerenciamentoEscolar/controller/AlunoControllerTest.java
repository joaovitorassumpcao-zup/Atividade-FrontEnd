package com.example.catalisa.gerenciamentoEscolar.controller;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.AlunoDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.service.AlunoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AlunoController.class)
class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AlunoService alunoService;

    @Test
    void testeListarAlunos() throws Exception{
        AlunoModel aluno1 = new AlunoModel();
        aluno1.setId(1L);
        aluno1.setNomeAluno("Maria Eduarda");
        AlunoModel aluno2 = new AlunoModel();
        aluno2.setId(2L);
        aluno2.setNomeAluno("Gabriel Silva");
        List<AlunoDTOExibicao> alunos = new ArrayList<>();
        alunos.add(new AlunoDTOExibicao(aluno1));
        alunos.add(new AlunoDTOExibicao(aluno2));

        when(alunoService.exibirAlunos()).thenReturn(alunos);

        mockMvc.perform(get("/api/alunos")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nomeAluno").value("Maria Eduarda"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nomeAluno").value("Gabriel Silva"));
    }


    @Test
    void testeCadastrarNovoAluno() throws Exception {
        mockMvc.perform(post("/api/alunos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\", \"nomeAluno\": \"Maria da Silva\", \"idadeAluno\": \"18\", \"email\": \"maria@gmail.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nomeAluno").value("Maria da Silva"))
                .andExpect(jsonPath("$.idadeAluno").value(18))
                .andExpect(jsonPath("$.email").value("maria@gmail.com"));
    }

    @Test
    void testeDeletarAluno() throws Exception {
        mockMvc.perform(delete("/api/alunos/{id}",anyLong()))
                .andExpect(status().isOk());
    }
}