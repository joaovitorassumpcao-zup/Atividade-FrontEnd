package com.example.catalisa.gerenciamentoEscolar.controller;

import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.ProfessorModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.CursoDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.ProfessorDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.service.CursoService;
import org.junit.jupiter.api.Disabled;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(CursoController.class)
class CursoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CursoService cursoService;

    @Test
    void testeListarCursos() throws Exception{

        CursoModel curso1 = new CursoModel(1L, "Medicina", 4000);
        CursoModel curso2 = new CursoModel(2L, "Direito", 4000);
        List<CursoDTOExibicao> cursos = new ArrayList<>();
        cursos.add(new CursoDTOExibicao(curso1));
        cursos.add(new CursoDTOExibicao(curso2));

        when(cursoService.exibirCursos()).thenReturn(cursos);

        mockMvc.perform(get("/api/cursos")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nomeCurso").value("Medicina"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nomeCurso").value("Direito"));
    }

    @Test
    void testeCadastrarNovoCurso() throws Exception{
        mockMvc.perform(post("/api/cursos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\", \"nomeCurso\": \"Medicina\", \"cargaHoraria\": \"4000\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nomeCurso").value("Medicina"))
                .andExpect(jsonPath("$.cargaHoraria").value(4000));

    }

    @Test
    void testeDeletarCurso() throws Exception{
        mockMvc.perform(delete("/api/cursos/{id}", anyLong()))
                .andExpect(status().isOk());
    }
}