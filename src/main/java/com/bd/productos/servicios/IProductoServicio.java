package com.bd.productos.servicios;

import java.util.List;

import com.bd.productos.modelo.ClassProducto;

public interface IProductoServicio {
	
	//Declaramos metodos
	public List<ClassProducto> ListadoProductos();
	public void RegistrarProducto(ClassProducto clpro);
	public ClassProducto BuscarPorId (Integer id);
	public void EliminarProducto(Integer id);

} //Fin de la interface iproductoservicio
