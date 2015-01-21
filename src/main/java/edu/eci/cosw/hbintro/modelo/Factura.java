package edu.eci.cosw.hbintro.modelo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;



@Entity
@Table (name = "facturas")
public class Factura implements Serializable {

	/** Primary key. */
	private int idfactura;
        /** Regular field. */
        private java.lang.String descripcion;
        /** Regular field. */
        private java.sql.Timestamp fecha;
        /** Association. */
        private Set<ItemsFactura> itemsFacturas;

	/**
	 * Constructor sin argumentos requerido por Hibernate
	 *
	 */
	public Factura(){
		this.itemsFacturas=new LinkedHashSet<ItemsFactura>();
	}
	
	public Factura(Timestamp fecha, String descripcion) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.itemsFacturas=new LinkedHashSet<ItemsFactura>();
	}

	/**
	 * Crear una factura con la fecha y descripcion dadas
	 * @param fecha
	 * @param descripcion
	 */
	public Factura(Calendar fecha, String descripcion) {
		Timestamp ts=new Timestamp(fecha.getTime().getTime());
		this.fecha = ts;
		this.descripcion = descripcion;
		this.itemsFacturas=new LinkedHashSet<ItemsFactura>();
	}

	/**
	 * Crear una factura con la hora actual
	 * @param descripcion
	 */
	public Factura(String descripcion) {
		Timestamp ts=new Timestamp(new GregorianCalendar().getTime().getTime());
		this.fecha = ts;
		this.descripcion = descripcion;
		this.itemsFacturas=new LinkedHashSet<ItemsFactura>();
	}

	
	public void agregarItemFactura(ItemsFactura it){
		itemsFacturas.add(it);
	}
	

	/**
	 * Get the primary key.
	 *
	 * @return The primary key.
	 */
	@Id 
	@GeneratedValue
	@Column(name = "idfactura")
	public int getIdfactura() {
		return idfactura;
	}

	/**
	 * Set the primary key.
	 *
	 * @param idfactura The primary key.
	 */
	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
	}


	/**
	 * Get the descripcion.
	 *
	 * @return The descripcion.
	 */
	@Column(name = "descripcion")	
	public java.lang.String getDescripcion() {		
		return descripcion;
	}

	/**
	 * Set the descripcion.
	 *
	 * @param descripcion The descripcion.
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * Get the fecha.
	 *
	 * @return The fecha.
	 */
	@Column(name = "fecha")
	public java.sql.Timestamp getFecha() {
		return fecha;
	}

	/**
	 * Set the fecha.
	 *
	 * @param fecha The fecha.
	 */
	public void setFecha(java.sql.Timestamp fecha) {
		this.fecha = fecha;
	}


	/**
	 * Get the itemsFacturas.
	 *
	 * @return The itemsFacturas.
	 */
	
	@OneToMany (fetch=FetchType.EAGER)
	@JoinColumn(name = "facturas_idfactura")
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
	public Set<ItemsFactura> getItemsFacturas() {
		return itemsFacturas;
	}

	/**
	 * Set the itemsFacturas.
	 *
	 * @param itemsFacturas The itemsFacturas.
	 */
	public void setItemsFacturas(Set<ItemsFactura> itemsFacturas) {
		this.itemsFacturas = itemsFacturas;
	}
}
