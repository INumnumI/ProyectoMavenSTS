package com.bd.productos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.productos.modelo.ClassProducto;
import com.bd.productos.servicios.IProductoServicio;

@Controller
@RequestMapping("/vistas")
public class ProductoController {
	//Aplicamos una inyeccion de dependencia
	@Autowired
	private IProductoServicio iproductoservicio;
	
	//Creamos un metodo para listar productos
	@GetMapping("/ListadoProductos")
	public String ListadoProducto(Model modelo) {
		List<ClassProducto> listar= iproductoservicio.ListadoProductos();
		//Para probar si recuperamos datos hasta la capa controlador
		for (ClassProducto lis:listar) {
			System.out.println("codigo producto "+lis.getIdproducto()+" nombre "+lis.getNombre());
		} //Fin del bucle for
		//Enviamos datos a la vista
		modelo.addAttribute("listadoproductos", listar);
		//retornar a la vista
		return "Vistas/Producto/ListadoProductos";
		
	} //Fin del metodo listado de productos
	
	//Metodo Registrar
	
	@GetMapping("/RegisProducto")
	public String RegistrarProducto(Model model) {
		//Realizamos la instancia
		ClassProducto clpro=new ClassProducto();
		//enviamos el objeto a la vista
		model.addAttribute("regproducto", clpro);
		//Retornar a la vista
		return "Vistas/Producto/FrmRegProducto";
	} //Fin Metodo Registar
	
	@PostMapping ("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute ClassProducto clpro) {
		//Inyeccion de Dependencia con metodo Registrar
		iproductoservicio.RegistrarProducto(clpro);
		//Retornamos lista
		return "redirect:/vistas/ListadoProductos";
	}//Fin del metodo guardar
	
	//Creamos el metodo Editar
	@GetMapping("/Editar/{id}")
	public String Editar(@PathVariable("id") Integer idpro,Model modelo) {
		//Buscar el codigo para el formulario
		ClassProducto buspro=iproductoservicio.BuscarPorId(idpro);
		//Enviamos a la vista
		modelo.addAttribute("regproducto",buspro);
		//retornar al formulario
		return "Vistas/Producto/FrmRegProducto";
	}//Fin del metodo editar
	
	@GetMapping("/Eliminar/{id}")
	public String Eliminar(@PathVariable("id") Integer idpro,Model modelo) {
		//Inyeccion de Dependencia
		iproductoservicio.EliminarProducto(idpro);
		List<ClassProducto> listado=iproductoservicio.ListadoProductos();
		//Enviamos a la vista
		modelo.addAttribute("listadoproductos", listado);
		//Retornamos lista
		return "redirect:/vistas/ListadoProductos";
	}//Fin del metodo eliminar
	
} //Fin del controlador
