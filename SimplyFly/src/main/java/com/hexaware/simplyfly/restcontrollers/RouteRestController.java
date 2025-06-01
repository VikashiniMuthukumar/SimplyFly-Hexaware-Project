package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.simplyfly.dto.RouteDTO;
import com.hexaware.simplyfly.entities.Route;
import com.hexaware.simplyfly.exceptions.RouteNotFoundException;
import com.hexaware.simplyfly.services.IRouteService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/routes")
public class RouteRestController {

    @Autowired
    private IRouteService routeService;

    @PostMapping
    public ResponseEntity<Route> createRoute(@Valid @RequestBody RouteDTO dto) {
        log.info("Creating Route with data: {}", dto);
        Route route = routeService.createRoute(dto);
        log.info("Route created with ID: {}", route.getRoute_id());
        return new ResponseEntity<>(route, HttpStatus.CREATED);
    }

    @PutMapping("/{routeId}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long routeId, @Valid @RequestBody RouteDTO dto) throws RouteNotFoundException {
        log.info("Updating Route with ID: {}", routeId);
        Route route = routeService.updateRoute(routeId, dto);
        log.info("Route updated: {}", route);
        return ResponseEntity.ok(route);
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long routeId) throws RouteNotFoundException {
        log.warn("Deleting Route with ID: {}", routeId);
        routeService.deleteRoute(routeId);
        log.info("Route deleted with ID: {}", routeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long routeId) throws RouteNotFoundException {
        log.info("Fetching Route with ID: {}", routeId);
        Route route = routeService.getRouteById(routeId);
        log.info("Route fetched: {}", route);
        return ResponseEntity.ok(route);
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        log.info("Fetching all Routes");
        List<Route> routes = routeService.getAllRoutes();
        log.info("Total Routes fetched: {}", routes.size());
        return ResponseEntity.ok(routes);
    }
}
