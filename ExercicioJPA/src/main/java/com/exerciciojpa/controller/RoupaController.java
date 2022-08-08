package com.exerciciojpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exerciciojpa.entidades.Roupa;
import com.exerciciojpa.repository.RoupaRepository;

@Controller
@RequestMapping("/")
public class RoupaController {
	@Autowired
	private RoupaRepository repo;

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String formCadastro() {
		return "cadastro";
	}
	
	@GetMapping("/consulta")
	public String formConsulta(Model model) {
		Iterable<Roupa> roupas = repo.findAll();
		model.addAttribute("roupas", roupas);
		return "consulta";
	}
	
	@GetMapping("/consulta/{idroupa}")
	public String formEditar(@PathVariable("idroupa") int id, Model model) {
		Roupa roupa = repo.findById(id).get();
		//System.out.println(roupa.getNome());
		model.addAttribute("roupa", roupa);
		return "edicao";
	}
	
	@PostMapping("/cadastro")
	public String salvar(Roupa roupa) {
		repo.save(roupa);
		return "redirect:/consulta";
	}
	@GetMapping("/delete/{idroupa}")
	public String delete(@PathVariable("idroupa") int id) {
		repo.deleteById(id);
		return "redirect:/consulta";
	}
}
