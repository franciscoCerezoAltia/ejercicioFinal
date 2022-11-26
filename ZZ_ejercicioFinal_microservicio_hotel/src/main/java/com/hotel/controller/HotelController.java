package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.Hotel;
import com.hotel.service.HotelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
public class HotelController {
	
	@Value("${eureka.instance.instance-id}")
	String instancia;
	
	@Autowired
	HotelService service;
	
	@ApiOperation(value = "Devuelve la información del hotel buscado por nombre")
	@GetMapping(value="hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotel (@ApiParam(value="Precio mínimo para la búsqueda") @PathVariable String nombre) {
		System.out.println(instancia);
		return service.buscarHotel(nombre);
	}
	
	@ApiOperation(value = "Devuelve la lista de todos los hoteles disponibles")
	@GetMapping(value="hotel",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hotel () {
		System.out.println(instancia);
		return service.hoteles();
	}

}
