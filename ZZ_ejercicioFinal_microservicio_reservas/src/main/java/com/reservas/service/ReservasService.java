package com.reservas.service;

import java.util.List;

import com.reservas.model.Reservas;
import com.reservas.model.RevervaPosible;

public interface ReservasService {
	
	void reservarVuelo (RevervaPosible revervaPosible);
	List<Reservas> buscarReservas (String nombre);	
	List<Reservas> mostrarTodasReservas ();

}
