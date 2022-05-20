package org.ciberfarma.controller;

import org.ciberfarma.model.Producto;
import org.ciberfarma.repository.ICategoriaRepository;
import org.ciberfarma.repository.IProductoRepository;
import org.ciberfarma.repository.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
	
	@Autowired
	private ICategoriaRepository repoc;
	
	@Autowired
	private IProveedorRepository repop;
	
	@Autowired
	private IProductoRepository repo;

	@GetMapping("/producto/cargar")
	public String cargarForm(Model model) {	
		model.addAttribute("producto", new Producto());
		// lst -> cboCategorias
		model.addAttribute("lstCategorias", repoc.findAll());
		// lst -> cboProveedores
		model.addAttribute("lstProveedores", repop.findAll());
		return "crudproductos";
	}
	
	@PostMapping("/producto/grabar")
	public String grabarForm(@ModelAttribute Producto producto, Model model) {		
		System.out.println(producto);
		model.addAttribute("lstCategorias", repoc.findAll());
		model.addAttribute("lstProveedores", repop.findAll());
		try {
			repo.save(producto); // merge -> si ID existe lo sobbrescribre o actualiza
			model.addAttribute("successful","PROCESO REGISTRADO CON EXITO");
		} catch (Exception e) {
			model.addAttribute("error","Error al registrar producto");
		}
		return "crudproductos";
	}
	
	@GetMapping("/producto/listar")
	public String listadoProductos(Model model) {	
		
		model.addAttribute("lstProductos", repo.findAll());
		return "listado";
	}
	
	@PostMapping("/producto/editar")
	public String buscarProd(@ModelAttribute Producto p, Model model) {		
		System.out.println(p);
		model.addAttribute("producto", repo.findById(p.getId_prod()));
		
		model.addAttribute("lstCategorias", repoc.findAll());
		model.addAttribute("lstProveedores", repop.findAll());
		System.out.println(p);
		return "crudproductos";
	}
}
