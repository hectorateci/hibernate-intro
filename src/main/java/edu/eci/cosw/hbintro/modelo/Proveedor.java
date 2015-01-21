package edu.eci.cosw.hbintro.modelo;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="proveedores")
public class Proveedor {

	int id;
	String NIT;
	String nombre;
	Collection<Producto> productos;
	
	
	public Proveedor(){}
	
	public Proveedor(String nit, String nombre) {
		super();
		NIT = nit;
		this.nombre = nombre;
		productos=new LinkedHashSet<Producto>();
	}
	
	@Id
	@Column(name="idProveedor")
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="NIT")
	public String getNIT() {
		return NIT;
	}
	public void setNIT(String nit) {
		NIT = nit;
	}
		
	@Column(name="Nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@ManyToMany(
			targetEntity=Producto.class,
			mappedBy="proveedores",
			fetch=FetchType.EAGER
	)
    public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}
	
	public void agregarProducto(Producto p){
		productos.add(p);
	}
	
}