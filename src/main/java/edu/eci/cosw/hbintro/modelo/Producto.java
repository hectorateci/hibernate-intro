package edu.eci.cosw.hbintro.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class Producto implements Serializable {

	/** Primary key. */
	private int idproducto;
	
	private Collection<Proveedor> proveedores;
	
	/** Regular field. */
	private java.lang.String nombre;

	/** Regular field. */
	private int precio;

	public Producto() {}

	public Producto(String nombre, int precio) {
		this.nombre = nombre;
		this.precio = precio;
		proveedores=new LinkedHashSet<>();
	}

	public void agregarProveedor(Proveedor p){
		proveedores.add(p);
	}

	/**
	 * Get the primary key.
	 *
	 * @return The primary key.
	 */
	public int getIdproducto() {
		return idproducto;
	}

	/**
	 * Get the nombre.
	 *
	 * @return The nombre.
	 */
	public java.lang.String getNombre() {
		return nombre;
	}

	/**
	 * Get the precio.
	 *
	 * @return The precio.
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Set the primary key.
	 *
	 * @param idproducto The primary key.
	 */
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	/**
	 * Set the nombre.
	 *
	 * @param nombre The nombre.
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}

	
	//Esta relaci???n se puede habilitar cuando se tenga el mapeo de los proveedores!
        /*@ManyToMany(
            targetEntity=Proveedor.class                    
        )
        @JoinTable(
    		name="productos_proveedores",
    		joinColumns={@JoinColumn(name="productos_idproducto")},
    		inverseJoinColumns={@JoinColumn(name="proveedores_idProveedor")}    			
        )
        @Fetch(FetchMode.JOIN)
	public Collection<Proveedor> getProveedores() {
		return proveedores;
	}*/

	/**
	 * Set the precio.
	 *
	 * @param precio The precio.
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	public void setProveedores(Collection<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
}