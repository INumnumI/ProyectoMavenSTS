package com.bd.productos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.productos.modelo.ClassProducto;
import com.bd.productos.repositorio.IProducto;

@Service
public class ClassProductoServicioImp implements IProductoServicio{
	//Implementamos la inyeccion de dependencia
	@Autowired
	private IProducto iproductorepository;
	
	@Override
	public List<ClassProducto> ListadoProductos() {
		// retornamos el listado de productos
		return (List<ClassProducto>) iproductorepository.findAll();
	} //Fin del metodo listado

	@Override
	public void RegistrarProducto(ClassProducto clpro) {
		// Registramos todos los datos a la bd
		iproductorepository.save(clpro);
		
	} //Fin del metodo registrar

	@Override
	public ClassProducto BuscarPorId(Integer id) {
		// buscamos un registro por codigo
		return iproductorepository.findById(id).orElse(null);
	} //Fin del metodo buscar

	@Override
	public void EliminarProducto(Integer id) {
		// Eliminamos producto por codigo
		iproductorepository.deleteById(id);
		
	} //Fin del metodo eliminar

} //Fin de la clase
