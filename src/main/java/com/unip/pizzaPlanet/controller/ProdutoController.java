package com.unip.pizzaPlanet.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unip.pizzaPlanet.model.Pedido;
import com.unip.pizzaPlanet.model.bd.ProdutoRepository;

@Controller
public class ProdutoController {
    @Autowired
    //private AlunoDAO alunoDAO;
    private ProdutoRepository produtoRepository;

    @RequestMapping("/listaProdutos")
    public ModelAndView listarAlunos(@ModelAttribute("aluno") Pedido aluno) {
        ModelAndView modelAndView = new ModelAndView("alunos");
        //modelAndView.addObject("listaDeAlunos", alunoDAO.listarAlunos());
        modelAndView.addObject("listaDeAlunos", produtoRepository.findAll());
        return modelAndView;
    }
    /*
    @RequestMapping("/selecionaAluno")
    public ModelAndView selecionarAlunos(@RequestParam("id") int matricula) {
        System.out.println("buscando o aluno: " + matricula);
        //Aluno aluno = alunoDAO.pesquisarAluno(matricula);
        Optional<Pedido> alunoTemp = produtoRepository.findById(Integer.valueOf(matricula));
        Pedido aluno = alunoTemp.get();
        System.out.println("aluno: " + aluno.getNome());

        ModelAndView modelAndView = new ModelAndView("alunos");
        //modelAndView.addObject("listaDeAlunos", alunoDAO.listarAlunos());
        modelAndView.addObject("listaDeAlunos", produtoRepository.findAll());
        modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }

    @PostMapping("/salvaAluno")
    public String salvarAluno(@ModelAttribute("aluno") Pedido aluno) {
        /*Aluno alunoTemp = alunoDAO.pesquisarAluno(aluno.getMatricula());
        if (alunoTemp != null) {
            alunoDAO.alterarAluno(aluno);
        } else
            alunoDAO.incluirAluno(aluno);*/
        /*
        produtoRepository.save(aluno);
        return "redirect:/listaAlunos";
    }
    @RequestMapping("/removeAluno")
    public String removerAluno(@RequestParam("id") int matricula) {
        //alunoDAO.excluirAluno(matricula);
        produtoRepository.deleteById(Integer.valueOf(matricula));
        return "redirect:/listaAlunos";
    
    }
    */
}
