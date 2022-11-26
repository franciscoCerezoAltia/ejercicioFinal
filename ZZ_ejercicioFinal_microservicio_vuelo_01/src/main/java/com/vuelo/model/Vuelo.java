package com.vuelo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vuelo")
public class Vuelo {
	
	@Id
	private Integer idVuelo;
	private String compañia;
	private Date fechaVuelo;
	private Integer precio;
	private Integer plazasDisponibles;

	public Vuelo() {
		super();
	}

	public Vuelo(Integer idVuelo, String compañia, Date fechaVuelo, Integer precio, Integer plazasDisponibles) {
		super();
		this.idVuelo = idVuelo;
		this.compañia = compañia;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public Date getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazasDisponibles(Integer plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}
	
		
}
