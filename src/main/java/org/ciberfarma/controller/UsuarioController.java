package org.ciberfarma.controller;

import org.ciberfarma.model.Usuario;
import org.ciberfarma.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

	
	@Autowired
	private IUsuarioRepository repou;
	
	@GetMapping("/login/cargar")
	public String cargarForm(Model model) {	
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping("/login/validar")
	public String validarIngreso(@ModelAttribute Usuario usuario, Model model) {		
		System.out.println(usuario);
		
		return "principal";
	}
}
