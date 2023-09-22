package com.example.catalisa.gerenciamentoEscolar.controller;


import com.example.catalisa.gerenciamentoEscolar.model.CursoModel;
import com.example.catalisa.gerenciamentoEscolar.model.ProfessorModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.ProfessorDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.service.ProfessorService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProfessorController.class)
class ProfessorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProfessorService professorService;

    @Test
    void testeListarProfessores() throws Exception{
        ProfessorModel professor1 = new ProfessorModel(1L, "Jigsaw da Silva",  50, 6000.0,new CursoModel(), 1L);
        ProfessorModel professor2 = new ProfessorModel(2L, "Fred Krueger Ferreira",  70, 10000.0,new CursoModel(), 2L);
        List<ProfessorDTOExibicao> professores = new ArrayList<>();
        professores.add(new ProfessorDTOExibicao(professor1));
        professores.add(new ProfessorDTOExibicao(professor2));

        when(professorService.exibirProfessores()).thenReturn(professores);

        mockMvc.perform(get("/api/professores")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nomeProfessor").value("Jigsaw da Silva"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].nomeProfessor").value("Fred Krueger Ferreira"));
    }

    @Test
    void testeCadastrarProfessor() throws Exception{
        mockMvc.perform(post("/api/professores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\", \"nomeProfessor\": \"Jigsaw da Silva\", \"idadeProfessor\": \"70\", \"salario\": \"4000.0\", \"cursos\": {\"id\": 1, \"nomeCurso\": \"Medicina\", \"cargaHoraria\": 4000}, \"cursosId\": \"1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nomeProfessor").value("Jigsaw da Silva"))
                .andExpect(jsonPath("$.idadeProfessor").value(70))
                .andExpect(jsonPath("$.salario").value(4000.0))
                .andExpect(jsonPath("$.cursos.id").value(1))
                .andExpect(jsonPath("$.cursos.nomeCurso").value("Medicina"))
                .andExpect(jsonPath("$.cursos.cargaHoraria").value(4000))
                .andExpect(jsonPath("$.cursosId").value(1));
    }
    @Test
    void testeDeletarProfessor() throws Exception{
        mockMvc.perform(delete("/api/professores/{id}", 1))
                .andExpect(status().isOk());
    }
}