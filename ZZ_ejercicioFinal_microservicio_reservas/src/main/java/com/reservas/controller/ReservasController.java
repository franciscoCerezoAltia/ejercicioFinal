package com.reservas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.model.Reservas;
import com.reservas.model.RevervaPosible;
import com.reservas.service.ReservasService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
public class ReservasController {
	
	@Value("${eureka.instance.instance-id}")
	String instancia;
	
	@Autowired
	ReservasService service;
	
	@ApiOperation(value = "Realiza la reserva del vuelo y hotel")
	@PostMapping(value="reservas",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void reservar (@ApiParam(value="Datos de la posible reserva") @RequestBody RevervaPosible revervaPosible) {
		System.out.println(instancia);
		service.reservarVuelo(revervaPosible);
	}
	
	@ApiOperation(value = "Devuelve las reservas existentes  en el hotel seleccionado")
	@GetMapping(value="reservas/{nombreHotel}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reservas> buscarReservas (@ApiParam(value="Nombre del hotel") @PathVariable String nombreHotel) {
		System.out.println(instancia);
		return service.buscarReservas(nombreHotel);
	}
	
	@ApiOperation(value = "Devuelve todas las reservas existentes")
	@GetMapping(value="reservas",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reservas> mostrarReservas () {
		System.out.println(instancia);
		return service.mostrarTodasReservas();
	}
	

}
