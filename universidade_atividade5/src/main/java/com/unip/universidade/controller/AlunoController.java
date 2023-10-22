package com.unip.universidade.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unip.universidade.model.Aluno;
import com.unip.universidade.model.bd.AlunoRepository;

@Controller
public class AlunoController {
    @Autowired
    //private AlunoDAO alunoDAO;
    private AlunoRepository alunoRepository;

    @RequestMapping("/listaAlunos")
    public ModelAndView listarAlunos(@ModelAttribute("aluno") Aluno aluno) {
        ModelAndView modelAndView = new ModelAndView("alunos");
        //modelAndView.addObject("listaDeAlunos", alunoDAO.listarAlunos());
        modelAndView.addObject("listaDeAlunos", alunoRepository.findAll());
        return modelAndView;
    }
    
    @RequestMapping("/selecionaAluno")
    public ModelAndView selecionarAlunos(@RequestParam("id") int matricula) {
        System.out.println("buscando o aluno: " + matricula);
        //Aluno aluno = alunoDAO.pesquisarAluno(matricula);
        Optional<Aluno> alunoTemp = alunoRepository.findById(Integer.valueOf(matricula));
        Aluno aluno = alunoTemp.get();
        System.out.println("aluno: " + aluno.getNome());

        ModelAndView modelAndView = new ModelAndView("alunos");
        //modelAndView.addObject("listaDeAlunos", alunoDAO.listarAlunos());
        modelAndView.addObject("listaDeAlunos", alunoRepository.findAll());
        modelAndView.addObject("aluno", aluno);
        return modelAndView;
    }

    @PostMapping("/salvaAluno")
    public String salvarAluno(@ModelAttribute("aluno") Aluno aluno) {
        /*Aluno alunoTemp = alunoDAO.pesquisarAluno(aluno.getMatricula());
        if (alunoTemp != null) {
            alunoDAO.alterarAluno(aluno);
        } else
            alunoDAO.incluirAluno(aluno);*/
        alunoRepository.save(aluno);
        return "redirect:/listaAlunos";
    }

    @RequestMapping("/removeAluno")
    public String removerAluno(@RequestParam("id") int matricula) {
        //alunoDAO.excluirAluno(matricula);
        alunoRepository.deleteById(Integer.valueOf(matricula));
        return "redirect:/listaAlunos";
    }

}
