package com.vuelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vuelo.model.Vuelo;
import com.vuelo.service.VueloService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
public class VueloController {
	
	@Value("${eureka.instance.instance-id}")
	String instancia;
	
	@Autowired
	VueloService service;
	
	@ApiOperation(value = "Devuelve la información del hotel buscado por nombre")
	@GetMapping(value="vuelo/{plazasReservar}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> buscarHotel (@ApiParam(value="Precio mínimo para la búsqueda") @PathVariable Integer plazasReservar) {
		System.out.println(instancia);
		return service.buscarVuelo(plazasReservar);
	}
	
	@ApiOperation(value = "Devuelve la lista de todos los hoteles disponibles")
	@PutMapping(value="vuelo/{idVuelo}/{plazasReservar}")
	public void reservarVuelo (@ApiParam (value="Identificador del vuelo") @PathVariable Integer idVuelo,  @ApiParam(value="Precio mínimo para la búsqueda") @PathVariable Integer plazasReservar) {
		System.out.println(instancia);
		System.out.println(idVuelo);
		System.out.println(plazasReservar);
		service.reservarVuelo(idVuelo, plazasReservar);
	}

}
