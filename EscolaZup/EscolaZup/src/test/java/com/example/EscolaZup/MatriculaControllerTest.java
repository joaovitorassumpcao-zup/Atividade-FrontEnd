package com.example.EscolaZup;

import com.example.EscolaZup.DTOS.MatriculaDTO;
import com.example.EscolaZup.controller.MatriculaController;
import com.example.EscolaZup.model.Matricula;
import com.example.EscolaZup.service.MatriculaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MatriculaController.class)
public class MatriculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MatriculaService matriculaService;

    @Test
    public void testFazerMatricula() throws Exception {
        MatriculaDTO matriculaDTO = new MatriculaDTO();
        Matricula novaMatricula = new Matricula();

        when(matriculaService.fazerMatricula(any(MatriculaDTO.class))).thenReturn(novaMatricula);

        mockMvc.perform(post("/api/matriculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(matriculaDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(novaMatricula.getId()));
    }
}
