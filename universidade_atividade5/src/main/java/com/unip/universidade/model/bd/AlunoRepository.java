package com.unip.universidade.model.bd;

import org.springframework.data.repository.CrudRepository;

import com.unip.universidade.model.Aluno;
import java.util.List;


public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
    List<Aluno> findByNomeOrMatricula(String nome, int matricula);
}
