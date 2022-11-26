package com.hotel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.model.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer> {

	//Todo viene heredado
	
	@Query("SELECT t FROM Hotel t WHERE t.disponible > 0")
    public List<Hotel> hoteles();
	
	@Query("SELECT t FROM Hotel t WHERE t.nombre = ?1 and t.disponible > 0")
    public Hotel hotelesNombre(String nombre);
}
