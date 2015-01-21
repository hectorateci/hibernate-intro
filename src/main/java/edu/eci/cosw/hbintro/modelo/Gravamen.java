package edu.eci.cosw.hbintro.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gravamenes")
public class Gravamen {

	

	private int idGravamen;

	private double porcentaje;

	private String descripcion;

	public Gravamen() {
		super();
	}

	public Gravamen(double porcentaje, String descripcion) {
		super();
		this.porcentaje = porcentaje;
		this.descripcion = descripcion;
	}

	@Column(name="descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	@Id
	@Column(name="id")
	@GeneratedValue
	public int getIdGravamen() {
		return idGravamen;
	}
	
	@Column(name="porcentaje")
	public double getPorcentaje() {
		return porcentaje;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setIdGravamen(int idGravamen) {
		this.idGravamen = idGravamen;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
}
