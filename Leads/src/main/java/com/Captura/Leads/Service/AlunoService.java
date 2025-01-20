package com.Captura.Leads.Service;

import com.Captura.Leads.DTO.AlunoDTO;
import com.Captura.Leads.Exceptions.MatriculaNotFoundException;
import com.Captura.Leads.Exceptions.TurmaNotFoundException;
import com.Captura.Leads.Exceptions.CursoNotFoundException;
import com.Captura.Leads.Models.Aluno;
import com.Captura.Leads.Models.Cursos;
import com.Captura.Leads.Models.Turmas;
import com.Captura.Leads.Repository.AlunoRepository;
import com.Captura.Leads.Repository.CursosRepository;
import com.Captura.Leads.Repository.TurmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursosRepository cursosRepository;

    @Autowired
    private TurmasRepository turmasRepository;

    public Aluno salvarMatricula(AlunoDTO alunoDTO){

        Cursos cursos = cursosRepository.findById(alunoDTO.getCurso_id())
                .orElseThrow(() -> new CursoNotFoundException("Curso com ID " + alunoDTO.getCurso_id() + " não encontrado."));

        Turmas turmas = turmasRepository.findById(alunoDTO.getCurso_id())
                .orElseThrow(()-> new TurmaNotFoundException("Turma não encontrada para o curso com ID " + alunoDTO.getCurso_id() + "."));

        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setData_cadastro(alunoDTO.getData_cadastro());
        aluno.setCursos(cursos);
        aluno.setTurmas(turmas);

        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarMatriculas(){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorMatricula(Long codigo_matricula){
        return alunoRepository.findById(codigo_matricula)
                .orElseThrow(()-> new MatriculaNotFoundException("Aluno com a matrícula "+codigo_matricula+"não encontrado no sistema."));
    }

    public void deletarPorMatricula(Long codigo_matricula){
        Aluno aluno= alunoRepository.findById(codigo_matricula)
                .orElseThrow(()-> new RuntimeException("A matrícula "+codigo_matricula+" não foi encontrada."));
        alunoRepository.delete(aluno);
    }

}
