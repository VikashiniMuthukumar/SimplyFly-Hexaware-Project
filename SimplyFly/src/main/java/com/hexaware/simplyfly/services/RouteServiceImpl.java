package com.hexaware.simplyfly.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.simplyfly.entities.Route;
import com.hexaware.simplyfly.repositories.RouteRepository;

@Service
public class RouteServiceImpl implements IRouteService{

	@Autowired
	RouteRepository repo;
	@Override
	public Route addRoute(Long flightId, Route route) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route getRouteById(Long routeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> getAllRoutes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Route> searchRoutes(String origin, String destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
