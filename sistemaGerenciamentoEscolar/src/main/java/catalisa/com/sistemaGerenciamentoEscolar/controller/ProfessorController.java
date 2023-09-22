package catalisa.com.sistemaGerenciamentoEscolar.controller;

import catalisa.com.sistemaGerenciamentoEscolar.DTO.ProfessorDTO;
import catalisa.com.sistemaGerenciamentoEscolar.model.Professor;
import catalisa.com.sistemaGerenciamentoEscolar.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;


    public ResponseEntity<List<ProfessorDTO>> listarTodosProfessores(){
        List<Professor> professores = professorService.listarTodosProfessores();
        List<ProfessorDTO> listaDTO = professores.stream().map(ProfessorDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listaDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> buscarProfessorPorId(@PathVariable Long id){
      Professor professor = professorService.buscarProfessoresPorId(id);

        return  ResponseEntity.ok().body(new ProfessorDTO(professor));
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<ProfessorDTO> cadastrarProfessor(@RequestBody Professor professor){
        professor = professorService.cadastrarProfessor(professor);


        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(professor.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProfessorDTO(professor));
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarProfessorPorId(@PathVariable Long id){
        professorService.deletarProfessoresPorId(id);
        return  ResponseEntity.noContent().build();
    }
    @PutMapping("@atualizar/{id}")
    public ResponseEntity<ProfessorDTO> atualizarProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        professor = professorService.alterarCadastroProfessor(id, professor);
        return ResponseEntity.ok().body(new ProfessorDTO(professor));
    }


}

