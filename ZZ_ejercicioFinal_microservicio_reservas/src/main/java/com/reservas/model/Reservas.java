package com.reservas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reservas {
	
	@Id
	private Integer idReserva;
	private String nombreCliente;
	private String nifCliente;
	private Integer idHotel;
	private Integer idVuelo;
	
	public Reservas() {
		super();
	}

	public Reservas(Integer idReserva, String nombreCliente, String nifCliente, Integer idHotel, Integer idVuelo) {
		super();
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.nifCliente = nifCliente;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNifCliente() {
		return nifCliente;
	}

	public void setNifCliente(String nifCliente) {
		this.nifCliente = nifCliente;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public Integer getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
	}
			
}
