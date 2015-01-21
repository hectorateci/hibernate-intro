package edu.eci.cosw.hbintro.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ItemfacturaPk implements Serializable{
	private int facturasIdFactura;
	private int productosIdProducto;
	
	public ItemfacturaPk(){
	}
	
	public ItemfacturaPk(int idFactura, int idProducto){
		facturasIdFactura = idFactura;
		productosIdProducto = idProducto;
	}
	
	@Column (name = "facturas_idfactura")
	public int getIdFactura() {
		return facturasIdFactura;
	}
	
	public void setIdFactura(int idFactura) {
		this.facturasIdFactura = idFactura;
	}
	
	@Column (name ="productos_idproducto")
	public int getIdProducto() {
		return productosIdProducto;
	}
	
	public void setIdProducto(int idProducto) {
		this.productosIdProducto = idProducto;
	}
}
