package com.reservas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reservas.dao.ReservasDao;
import com.reservas.model.Hotel;
import com.reservas.model.Reservas;
import com.reservas.model.RevervaPosible;

@Service
public class ReservasServiceImpl implements ReservasService {
	
	@Autowired
	ReservasDao reservasDao;
	
	private String urlHotel="http://servicioHotel/";
	private String urlVuelo="http://servicioVuelo/";

	@Autowired
	RestTemplate template;
	
	@Override
	public void reservarVuelo(RevervaPosible revervaPosible) {
		Reservas reservas = new Reservas();
		reservas.setIdHotel(revervaPosible.getIdHotel());
		reservas.setIdVuelo(revervaPosible.getIdVuelo());
		reservas.setNifCliente(revervaPosible.getNifCliente());
		reservas.setNombreCliente(revervaPosible.getNombreCliente());
		template.put(urlVuelo + "vuelo/"+revervaPosible.getIdVuelo()+"/"+revervaPosible.getPlazasDisponibles(), null);
		reservas.setIdReserva(mostrarTodasReservas().size()+1);
		reservasDao.saveAndFlush(reservas);
	}

	@Override
	public List<Reservas> buscarReservas(String nombre) {
		Hotel hotel = template.getForObject(urlHotel + "hotel/" + nombre , Hotel.class);
		return reservasDao.localizarReservasHotel(hotel.getIdHotel());
	}

	@Override
	public List<Reservas> mostrarTodasReservas() {
		return reservasDao.findAll();
	}

	

}
