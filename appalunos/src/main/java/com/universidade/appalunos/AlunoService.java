package com.universidade.appalunos;

import java.util.List;

public interface AlunoService {
    
    List<Aluno> getAllAlunos();
    Aluno salvarAluno(Aluno aluno);
    Aluno getAlunoByIdAluno(Long id);
    Aluno atualizarAluno(Aluno aluno);
    void excluirAlunoById(Long id);

}
