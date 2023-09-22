package com.EscolaZup;

import com.EscolaZup.controller.CursoController;
import com.EscolaZup.mapper.CursoMapper;
import com.EscolaZup.model.Curso;
import com.EscolaZup.service.CursoService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest(CursoController.class)
public class CursoControllerTest {

    @MockBean
    private CursoService cursoService;

    @MockBean
    private CursoMapper cursoMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test //Teste do endpoint para listar todos os cursos
    public void buscaTodosAlunosTest() throws Exception {
        when(cursoService.buscarTodos())
                .thenReturn(List.of(new Curso(1L, "lógica de programação", 60)));
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/api/zupescola/cursos")).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("lógica de programação"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].cargahoraria").value(60));
    }

    @Test //Teste do endpoint para cadastrar curso
    public void cadastraCursoTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/zupescola/cadastracurso")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"lógica de programação\",\"cargahoraria\":60}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test //Teste do endpoind de delete
    public void deletaCursoTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/api/zupescola/deletecurso/{id}", "0")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
