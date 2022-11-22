package com.universidade.appalunos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService{

    //DECLARAÇÃO DE VARIÁVEL
    @Autowired
    private AlunoRepository alunoRepository;

    //CONSTRUTOR
    public AlunoServiceImpl(AlunoRepository alunoRepository){
        super();
        this.alunoRepository = alunoRepository;
    }

    //função que faz o retorno da lista de todos os alunos do BD
    @Override
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    //função que retorna dados do aluno salvando no BD
    @Override
    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    //função que retorna dados do aluno pelo ID
    @Override
    public Aluno getAlunoByIdAluno(Long id) {
        return alunoRepository.findById(id).get();
    }

    
//função que edita e retorna dados atualizados do aluno
    @Override
    public Aluno atualizarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    //função que deleta aluno pelo ID
    @Override
    public void excluirAlunoById(Long id) {
        alunoRepository.deleteById(id);
    }
}
