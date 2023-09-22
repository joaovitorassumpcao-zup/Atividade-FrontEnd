package com.example.EscolaZup;

import com.example.EscolaZup.DTOS.CursoDTO;
import com.example.EscolaZup.controller.CursoController;
import com.example.EscolaZup.model.Curso;
import com.example.EscolaZup.service.CursoService;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoService cursoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCadastrarCurso() throws Exception {
        CursoDTO cursoDTO = new CursoDTO();
        Curso novoCurso = new Curso();

        when(cursoService.cadastrarCurso(any(CursoDTO.class))).thenReturn(novoCurso);

        mockMvc.perform(post("/api/cursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cursoDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(novoCurso.getId()))
                .andExpect(jsonPath("$.nome").value(novoCurso.getNome()));
    }

    @Test
    public void testListarCurso() throws Exception {
        List<Curso> cursos = Arrays.asList(
                new Curso(1L, "Curso 1"),
                new Curso(2L, "Curso 2")
        );

        when(cursoService.listarCurso()).thenReturn(cursos);

        mockMvc.perform(get("/api/cursos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(cursos.size()));
    }

    @Test
    public void testDeletarCurso() throws Exception {
        Long cursoId = 1L;

        mockMvc.perform(delete("/api/cursos/{cursoId}", cursoId))
                .andExpect(status().isOk())
                .andExpect(content().string("Curso deletado com sucesso."));

        verify(cursoService).deletarCurso(cursoId);
    }

}
