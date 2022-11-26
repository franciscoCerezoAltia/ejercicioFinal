package com.reservas.model;

public class RevervaPosible {
	
	private String nombreCliente;
	private String nifCliente;
	private int idHotel;
	private int idVuelo;
	private int plazasDisponibles;
	
	public RevervaPosible() {
		super();
	}

	public RevervaPosible(String nombreCliente, String nifCliente, int idHotel, int idVuelo, int plazasDisponibles) {
		super();
		this.nombreCliente = nombreCliente;
		this.nifCliente = nifCliente;
		this.idHotel = idHotel;
		this.idVuelo = idVuelo;
		this.plazasDisponibles = plazasDisponibles;
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

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazasDisponibles(int plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}	

}
