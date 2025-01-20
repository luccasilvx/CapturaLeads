package com.Captura.Leads.Controller;

import com.Captura.Leads.DTO.AlunoDTO;
import com.Captura.Leads.Models.Aluno;
import com.Captura.Leads.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping("/salvar")
    public ResponseEntity<Aluno> salvarMatricula(@RequestBody AlunoDTO alunoDTO){
        Aluno novaMatricula = alunoService.salvarMatricula(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMatricula);
    }

    @GetMapping("/listar_matriculados")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Aluno>> listarMatriculas(){
        return ResponseEntity.ok(alunoService.listarMatriculas());
    }

    @GetMapping("/buscar_matricula/{codigo_matricula}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno buscarPorMatricula(@PathVariable Long codigo_matricula){
        return alunoService.buscarPorMatricula(codigo_matricula);
    }

    @DeleteMapping("/excluir_matricula/{codigo_matricula}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deletarPorMatricula(Long codigo_matricula){
        alunoService.deletarPorMatricula(codigo_matricula);
        return ResponseEntity.noContent().build();
    }
}
