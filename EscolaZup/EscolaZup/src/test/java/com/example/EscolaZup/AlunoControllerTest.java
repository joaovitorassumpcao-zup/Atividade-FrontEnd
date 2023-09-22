package com.example.EscolaZup;

import com.example.EscolaZup.DTOS.AlunoDTO;
import com.example.EscolaZup.controller.AlunoController;
import com.example.EscolaZup.model.Aluno;
import com.example.EscolaZup.service.AlunoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoService alunoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllAlunos() throws Exception {
        List<Aluno> alunos = Arrays.asList(
                new Aluno(1L, "Alice", 20, "alice@example.com"),
                new Aluno(2L, "Bob", 22, "bob@example.com")
        );

        Mockito.when(alunoService.listarAluno()).thenReturn(alunos);

        mockMvc.perform(get("/api/alunos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(alunos.size()));
    }

    @Test
    public void testCreateAluno() throws Exception {
        Aluno aluno = new Aluno(4L, "Maria", 34, "maria@gmail.com");

        Mockito.when(alunoService.cadastrarAluno(Mockito.any(AlunoDTO.class))).thenReturn(aluno);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/alunos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aluno)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))                .andExpect(jsonPath("$.nome").value(aluno.getNome()))
                .andExpect(jsonPath("$.idade").value(aluno.getIdade()))
                .andExpect(jsonPath("$.email").value(aluno.getEmail()));

    }



    @Test
    public void testAtualizarCursoDoAluno() throws Exception {
        Long alunoId = 1L;
        Long novoCursoId = 2L;

        mockMvc.perform(put("/api/alunos/{alunoId}/curso", alunoId)
                        .param("novoCursoId", String.valueOf(novoCursoId)))
                .andExpect(status().isOk());

        verify(alunoService).atualizarCursoDoAluno(alunoId, novoCursoId);
    }

    @Test
    public void testDeletarAluno() throws Exception {
        Long alunoId = 1L;

        mockMvc.perform(delete("/api/alunos/{alunoId}", alunoId))
                .andExpect(status().isOk());

        verify(alunoService).deletarAluno(alunoId);
    }

}
