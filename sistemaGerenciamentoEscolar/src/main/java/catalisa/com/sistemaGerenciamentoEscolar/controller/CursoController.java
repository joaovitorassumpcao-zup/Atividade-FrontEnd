package catalisa.com.sistemaGerenciamentoEscolar.controller;


import catalisa.com.sistemaGerenciamentoEscolar.DTO.CursoDTO;


import catalisa.com.sistemaGerenciamentoEscolar.model.Curso;

import catalisa.com.sistemaGerenciamentoEscolar.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;


    public ResponseEntity<List<CursoDTO>> listarTodosCursos(){
        List<Curso> cursos = cursoService.listarTodosCursos();
        List<CursoDTO> listaDTO = cursos.stream().map(CursoDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listaDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> buscarCursoPorId(@PathVariable Long id){
        Curso curso = cursoService.buscarCursoPorId(id);
        return  ResponseEntity.ok().body(new CursoDTO(curso));
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<CursoDTO> cadastrarCurso(@RequestBody Curso curso){
        curso = cursoService.cadastrarCurso(curso);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoDTO(curso));
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> ddeletarCursoPorId(@PathVariable Long id){
        cursoService.deletarCursoPorId(id);
        return  ResponseEntity.noContent().build();
    }
    @PutMapping("@atualizar/{id}")
    public ResponseEntity<CursoDTO> atualizarCurso(@PathVariable Long id, @RequestBody Curso curso){
        curso = cursoService.alterarCadastroCurso(id, curso);
        return  ResponseEntity.ok().body(new CursoDTO(curso));
    }


}
