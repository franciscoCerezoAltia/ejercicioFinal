package com.vuelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuelo.dao.VueloDao;
import com.vuelo.model.Vuelo;

@Service
public class VueloServiceImpl implements VueloService {
	
	@Autowired
	VueloDao vueloDao;

	@Override
	public List<Vuelo> buscarVuelo(Integer plazasReservar) {
		return vueloDao.vuelos(plazasReservar);
	}

	@Override
	public void reservarVuelo(Integer idVuelo, Integer plazasReservadas) {
		System.out.println(idVuelo);
		Vuelo vueloTemp = vueloDao.findById(idVuelo).orElse(null); 
		vueloTemp.setPlazasDisponibles(vueloTemp.getPlazasDisponibles()-plazasReservadas);
		vueloDao.save(vueloTemp);
	}

}
