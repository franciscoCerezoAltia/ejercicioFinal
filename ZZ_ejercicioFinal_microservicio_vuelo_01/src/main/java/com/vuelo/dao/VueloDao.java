package com.vuelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vuelo.model.Vuelo;

public interface VueloDao extends JpaRepository<Vuelo, Integer> {

	//Todo viene heredado
	
	@Query("SELECT t FROM Vuelo t WHERE t.plazasDisponibles > ?1")
    public List<Vuelo> vuelos(Integer plazasReservadas);
}
