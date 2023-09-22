package com.EscolaZup;

import com.EscolaZup.controller.AlunoController;
import com.EscolaZup.mapper.AlunoMapper;
import com.EscolaZup.model.Aluno;
import com.EscolaZup.model.Curso;
import com.EscolaZup.model.Professor;
import com.EscolaZup.service.AlunoService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {
    @MockBean
    AlunoService alunoService;

    @MockBean
    AlunoMapper alunoMapper;

    @Autowired
    MockMvc mockMvc;

    @Test //Teste do endpoint de cadastro do aluno
    public void cadastraAlunoTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/zupescola/cadastraaluno")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Tio .faso\",\"idade\":\"40\",\"email\":\"fabio.vaz@zup.com.br\"}"))
                .andExpect(status().isCreated());
    }

    @Test //Teste do endpoint para listar todos os alunos
    public void buscaTodosAlunosTest() throws Exception {

        when(alunoService.buscarTodos())
                .thenReturn(List.of(new Aluno(1L,"Tio .faso",40,"fabio.vaz@zup.com.br")));
        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/zupescola/alunos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Tio .faso"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idade").value(40))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("fabio.vaz@zup.com.br"));
    }
    @Test //Teste do endpoint de delete
    public void deletaAlunoTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/api/zupescola/deletealuno/{id}", "0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
