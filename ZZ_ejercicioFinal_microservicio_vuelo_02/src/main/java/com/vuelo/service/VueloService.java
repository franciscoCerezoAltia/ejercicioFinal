package com.vuelo.service;

import java.util.List;

import com.vuelo.model.Vuelo;

public interface VueloService {
	
	List<Vuelo> buscarVuelo (Integer plazasReservar);
	void reservarVuelo (Integer idVuelo, Integer plazasReservadas);
}
