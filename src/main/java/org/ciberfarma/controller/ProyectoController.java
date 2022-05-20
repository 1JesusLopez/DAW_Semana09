package org.ciberfarma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProyectoController {

	//Crear y mapear acciones: get (url, href) y post (form)
	
	@GetMapping("/saludo")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World")
							String name, Model model) {	
		/*
		 * @RequestParam = accion, recibe parametros
		 * 	required = false ---> el parametro es opcional
		 * 	defaultValue	=	"World", valor si no se pasa un parametro
		 * en Servlet : name = request.getParameter("name")
		 * Model una clase utilizada para "enviar" informacion (Attribute, paginas)
		 */		
		model.addAttribute("name", name);
		// En Servlet : request.setAttribute("name"
		return "saluditos"; 	// "saluditos" es el nombre de la pagina
		// En Servlet : request.getRequesDispatcher....
	}
	
	@PostMapping("/saludo")
	public String greetingPost(@RequestParam(name = "name", required = false, defaultValue = "World")
								String name, Model model) {	
		model.addAttribute("name", name);
		return "saluditos";
	}
}
