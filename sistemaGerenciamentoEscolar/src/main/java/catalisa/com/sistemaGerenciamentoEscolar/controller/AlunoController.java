package catalisa.com.sistemaGerenciamentoEscolar.controller;

import catalisa.com.sistemaGerenciamentoEscolar.DTO.AlunoDTO;
import catalisa.com.sistemaGerenciamentoEscolar.model.Aluno;
import catalisa.com.sistemaGerenciamentoEscolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;
@CrossOrigin(origins = "http://127.0.0.1.5500")

    @GetMapping

    public ResponseEntity<List<AlunoDTO>> listarTodosAlunos(){
    List<Aluno> alunos = alunoService.listarTodosAlunos();
    List<AlunoDTO> listaDTO = alunos.stream().map(AlunoDTO::new).collect(Collectors.toList());
    return  ResponseEntity.ok().body(listaDTO);
}
@GetMapping("/{id}")
public ResponseEntity<AlunoDTO> buscarAlunoPorId(@PathVariable Long id){
    Aluno aluno = alunoService.buscarAlunoPorId(id);
    return  ResponseEntity.ok().body(new AlunoDTO(aluno));
}
    @CrossOrigin(origins = "http://127.0.0.1.5500")

@PostMapping("/cadastrar")
    public ResponseEntity<AlunoDTO> cadastrarAluno(@RequestBody Aluno aluno){
    aluno = alunoService.cadastrarAluno(aluno);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(aluno.getId()).toUri();
   return ResponseEntity.created(uri).body(new AlunoDTO(aluno));
}

@DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAlunoPorId(@PathVariable Long id){
    alunoService.deletarAlunoPorId(id);
    return  ResponseEntity.noContent().build();
}
@PutMapping("@atualizar/{id}")
public ResponseEntity<AlunoDTO> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno){
    aluno = alunoService.alterarCadastroAluno(id, aluno);
    return  ResponseEntity.ok().body(new AlunoDTO(aluno));
}

}
