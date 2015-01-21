package edu.eci.cosw.hbintro.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "items_factura")
public class ItemsFactura implements Serializable {

	public ItemsFactura(int cantidad, Producto producto) {
		this.cantidad = cantidad;
		this.producto = producto;
	}

	/** Standard constructor, initializing the primary key. */
	public ItemsFactura() {
		
	}

	
	/** Regular field. */
	private int cantidad;

	/**
	 * Get the cantidad.
	 *
	 * @return The cantidad.
	 */
	
	@Column (name = "cantidad")
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Set the cantidad.
	 *
	 * @param cantidad The cantidad.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/** Association. */
	private Producto producto;

	/**
	 * Get the producto.
	 *
	 * @return The producto.
	 */
	@ManyToOne
	@JoinColumn (name = "productos_idproducto", insertable = false, updatable = false)
	public Producto getProducto() {
		return producto;
	}

	/**
	 * Set the producto.
	 *
	 * @param producto The producto.
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	private ItemfacturaPk itemFacturaPk;
	
	/**
	 * @return the itemFacturaPk
	 */
	@EmbeddedId
	@GeneratedValue
	public ItemfacturaPk getItemFacturaPk() {
		return itemFacturaPk;
	}

	/**
	 * @param itemFacturaPk the itemFacturaPk to set
	 */
	public void setItemFacturaPk(ItemfacturaPk itemFacturaPk) {
		this.itemFacturaPk = itemFacturaPk;
	}

}
