package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.HotelDao;
import com.hotel.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelDao hotelDao;

	@Override
	public List<Hotel> hoteles() {
		return hotelDao.hoteles();
	}

	@Override
	public Hotel buscarHotel(String nombre) {
		return hotelDao.hotelesNombre(nombre);
	}

	

}
