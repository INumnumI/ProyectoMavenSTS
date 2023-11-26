package com.bd.productos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tbl_ProductoCl3")

public class ClassProducto {
	//declaramos sus atributos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproducto;
	
	private String nombre;
    private double precioVenta;
    private double precioCompra;
    private String estado;
    private String descripcion;
    private int stock;
    
    //Metodo String
    @Override
	public String toString() {
		return "ClassProducto [idproducto=" + idproducto + ", nombre=" + nombre + ", precioVenta=" + precioVenta
				+ ", stock=" + stock + ", precioCompra=" + precioCompra + ", estado=" + estado + ", descripcion="
				+ descripcion + "]";
	} //Fin del metodo String

	public ClassProducto() {
    	
    } //Fin del constructor vacio
    
	//Constructores
    public ClassProducto(int idproducto, String nombre, double precioVenta, int stock, double precioCompra,
			String estado, String descripcion) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.stock = stock;
		this.precioCompra = precioCompra;
		this.estado = estado;
		this.descripcion = descripcion;
	} //Fin del metodo constructor con parametros
    
	//setters y getters
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
    
} //fin de la clase
