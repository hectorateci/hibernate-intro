package edu.eci.cosw.hbintro.modelo;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="pedidos")
public class Pedido {

	
	private int id;
	
	private int cantidad;

	private Producto producto;

	private Set<Gravamen> gravamenes;
	
	public Pedido() {
		gravamenes=new LinkedHashSet<Gravamen>();		
	}

	public Pedido(int cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		gravamenes=new LinkedHashSet<Gravamen>();
	}

	public void agregarGravamen(Gravamen g){
		gravamenes.add(g);
	}
	
	@Column(name="cantidad")
	public int getCantidad() {
		return cantidad;
	}

	@OneToMany
	@JoinColumn(name="productos_fk")
	@Cascade(value=CascadeType.ALL)
	public Set<Gravamen> getGravamenes() {
		return gravamenes;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="producto_fk")
	@Cascade(value=CascadeType.ALL)
	public Producto getProducto() {
		return producto;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setGravamenes(Set<Gravamen> gravamenes) {
		this.gravamenes = gravamenes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
