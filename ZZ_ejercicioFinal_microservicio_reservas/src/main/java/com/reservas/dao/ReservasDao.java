package com.reservas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reservas.model.Reservas;



public interface ReservasDao extends JpaRepository<Reservas, Integer> {

	//Todo viene heredado
	
	/**
	@Query("SELECT t FROM Hotel t WHERE t.disponible > 0")
    public List<Reserva> hoteles();
	
	@Query("SELECT t FROM Hotel t WHERE t.nombre = ?1 and t.disponible > 0")
    public Reserva hotelesNombre(String nombre);
    
    **/
	
	@Query("SELECT t FROM Reservas t WHERE t.idHotel = ?1")
	public List<Reservas> localizarReservasHotel (int idHotel); 
	
}
