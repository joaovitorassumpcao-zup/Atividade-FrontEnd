package com.example.EscolaZup;
import com.example.EscolaZup.model.Professor;
import com.example.EscolaZup.DTOS.ProfessorDTO;
import com.example.EscolaZup.controller.ProfessorController;
import com.example.EscolaZup.service.ProfessorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfessorController.class)
public class ProfessorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfessorService professorService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testCadastrarProfessor() throws Exception {
        ProfessorDTO professorDTO = new ProfessorDTO();
        Professor novoProfessor = new Professor();


        when(professorService.cadastrarProfessor(any(ProfessorDTO.class))).thenReturn(novoProfessor);

        mockMvc.perform(post("/api/professores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(professorDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(novoProfessor.getId()))
                .andExpect(jsonPath("$.nome").value(novoProfessor.getNome()));
    }

    @Test
    public void testListarProfessor() throws Exception {
        List<Professor> professores = Arrays.asList(
                new Professor(1L, "Professor 1"),
                new Professor(2L, "Professor 2")
        );

        when(professorService.listarProfessor()).thenReturn(professores);

        mockMvc.perform(get("/api/professores"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(professores.size()));
    }

    @Test
    public void testDeletarProfessor() throws Exception {
        Long professorId = 1L;

        mockMvc.perform(delete("/api/professores/{professorId}", professorId))
                .andExpect(status().isOk())
                .andExpect(content().string("Professor deletado com sucesso."));

        verify(professorService).deletarProfessor(professorId);
    }
}
