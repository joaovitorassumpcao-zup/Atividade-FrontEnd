package com.EscolaZup;

import com.EscolaZup.controller.ProfessorController;
import com.EscolaZup.mapper.ProfessorMapper;
import com.EscolaZup.model.Curso;
import com.EscolaZup.model.Professor;
import com.EscolaZup.service.ProfessorService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProfessorController.class)
public class ProfessorControllerTest {
    @MockBean
    private ProfessorService professorService;

    @MockBean
    private ProfessorMapper professorMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test //Teste do endpoint de cadastro do professor
    public void cadastraProfessorTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/zupescola/cadastraprofessor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Henry Sobotta e Tira\",\"idade\":\"70\",\"cursoid\":3,\"salario\":5000}"))
                .andExpect(status().isCreated());
    }

    @Test //Teste do endpoint para listar todos os professores
    public void buscaTodosProfessoresTest() throws Exception {
        BigDecimal salario = new BigDecimal("2500.0");
        Curso curso = new Curso(1L, "lógica de programação", 60);

        when(professorService.buscarTodos())
                .thenReturn(List.of(new Professor(1L,"Alfredo Assunção",35,curso,1L,salario)));
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/zupescola/professores"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Alfredo Assunção"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idade").value(35))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].salario").value(salario.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.curso").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].cursoid").value(1));
    }

    @Test //Teste do endpoint de delete
    public void deletaProfessorTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/api/zupescola/deleteprofessor/{id}", "0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
