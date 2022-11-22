package com.universidade.appalunos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AlunoController {
    //DECLARAÇÃO DE VARIÁVEL (cria uma variável da classe AlunoService)
    private AlunoService alunoService;
    
    //CONSTRUTOR
    public AlunoController(AlunoService alunoService){
        super();
        this.alunoService = alunoService;
    }
    
    // MAPEAMENTOS (GET E POST)
    // Mapeamento do index.html (tabela com todos os alunos)
    @RequestMapping(value = "/")
    public String listarAlunos(Model model){
        model.addAttribute("aluno", alunoService.getAllAlunos());
        return "index";
    }

    // Mapeamento do cadastrar.html (puxa a página)
    @GetMapping("/alunos/cadastro")
    public String cadastrarAluno(Model model){
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "cadastrar";
    }

    // Mapeamento do cadastrar.html (salva no BD e retorna pra tabela)
    @PostMapping("/alunos")
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno){
        alunoService.salvarAluno(aluno);
        return "redirect:/";
    }

    // Mapeamento do editar.html (puxa a página)
    @GetMapping("/alunos/editar/{id}")
    public String editarAluno(@PathVariable Long id, Model model) {
        model.addAttribute("aluno", alunoService.getAlunoByIdAluno(id));
        return "editar";
    }

    // Mapeamento do editar.html (salva no BD e retorna pra tabela)
    @PostMapping("/alunos/{id}")
    public String atualizarAluno(@PathVariable Long id, @ModelAttribute("aluno") Aluno aluno, Model model) {
        Aluno existenciaDeAluno = alunoService.getAlunoByIdAluno(id);
        existenciaDeAluno.setId(id);
        existenciaDeAluno.setNome(aluno.getNome());
        existenciaDeAluno.setIdade(aluno.getIdade());
        existenciaDeAluno.setCurso(aluno.getCurso());
        alunoService.atualizarAluno(existenciaDeAluno);
        return "redirect:/";
    }

    // Mapeamento do botão excluir (exclui a linha no BD e retorna pra tabela)
    @GetMapping("/alunos/excluir/{id}")
    public String excluirAluno(@PathVariable Long id){
        alunoService.excluirAlunoById(id);
        return "redirect:/";
    }
}
