package com.example.catalisa.gerenciamentoEscolar.controller;

import com.example.catalisa.gerenciamentoEscolar.model.AlunoModel;
import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.MatriculaModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.MatriculaDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.service.MatriculaService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(MatriculaController.class)
class MatriculaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MatriculaService matriculaService;

    @Test
    void testeModificarCursoAchouMatricula() throws Exception {

        MatriculaModel matriculaModificada = new MatriculaModel();

        when(matriculaService.editarMatricula(anyLong(),anyLong())).thenReturn(matriculaModificada);

        mockMvc.perform(put("/api/matriculas/{id}", anyLong())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(anyLong())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(matriculaModificada.getId()))
                .andExpect(jsonPath("$.cursosId").value(matriculaModificada.getCursosId()));

        verify(matriculaService, times(1)).editarMatricula(anyLong(), anyLong());

    }
    @Test
    void testeModificarCursoNãoAchouMatricula() throws Exception {

        when(matriculaService.editarMatricula(anyLong(),anyLong())).thenReturn(null);
        mockMvc.perform(put("/api/matriculas/{id}",anyLong())
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(anyLong())))
                .andExpect(status().isNotFound());

    }
    @Test
    void testeListarMatriculas() throws Exception{
        MatriculaModel matricula1 = new MatriculaModel(1L, LocalDate.parse("2020-10-10"),new AlunoModel(),1L, new CursoModel(),1L);
        MatriculaModel matricula2 = new MatriculaModel(2L, LocalDate.parse("2020-10-11"),new AlunoModel(),2L, new CursoModel(),1L);

        List<MatriculaDTOExibicao> matriculas = new ArrayList<>();
        matriculas.add(new MatriculaDTOExibicao(matricula1));
        matriculas.add(new MatriculaDTOExibicao(matricula2));

        when(matriculaService.exibirMatriculas()).thenReturn(matriculas);

        mockMvc.perform(get("/api/matriculas")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].alunosId").value(1))
                .andExpect(jsonPath("$[0].cursosId").value(1))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].alunosId").value(2))
                .andExpect(jsonPath("$[1].cursosId").value(1));
    }

    @Test
    void testeFazerNovaMatricula() throws Exception{
        mockMvc.perform(post("/api/matriculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\", \"dataMatricula\": \"2020-10-10\", \"alunos\": {\"id\": 1, \"nomeAluno\": \"Maria da Silva\", \"idadeAluno\": 20, \"email\": \"maria@gmail.com\"}, \"alunosId\": \"1\", \"cursos\": {\"id\": 1, \"nomeCurso\": \"Medicina\", \"cargaHoraria\": 4000}, \"cursosId\": \"1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.dataMatricula").value("2020-10-10"))
                .andExpect(jsonPath("$.alunos.id").value(1))
                .andExpect(jsonPath("$.alunos.nomeAluno").value("Maria da Silva"))
                .andExpect(jsonPath("$.alunos.idadeAluno").value(20))
                .andExpect(jsonPath("$.alunos.email").value("maria@gmail.com"))
                .andExpect(jsonPath("$.alunosId").value(1))
                .andExpect(jsonPath("$.cursos.id").value(1))
                .andExpect(jsonPath("$.cursos.nomeCurso").value("Medicina"))
                .andExpect(jsonPath("$.cursos.cargaHoraria").value(4000))
                .andExpect(jsonPath("$.cursosId").value(1));
    }

    @Test
    void testeDeletarMatricula() throws Exception{
        mockMvc.perform(delete("/api/matriculas/{id}",anyLong()))
                .andExpect(status().isOk());
    }
}