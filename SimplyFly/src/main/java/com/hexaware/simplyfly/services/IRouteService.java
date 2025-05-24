package com.hexaware.simplyfly.services;

import java.util.List;

import com.hexaware.simplyfly.entities.Route;

public interface IRouteService {

	Route addRoute(Long flightId, Route route);
	Route getRouteById(Long routeId);
    List<Route> getAllRoutes();
    List<Route> searchRoutes(String origin, String destination);
}
