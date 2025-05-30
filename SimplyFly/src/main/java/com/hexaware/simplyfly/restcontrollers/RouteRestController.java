package com.hexaware.simplyfly.restcontrollers;

import java.util.List;

import com.hexaware.simplyfly.dto.RouteDTO;
import com.hexaware.simplyfly.entities.Route;
import com.hexaware.simplyfly.exceptions.RouteNotFoundException;
import com.hexaware.simplyfly.services.IRouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
public class RouteRestController {

    @Autowired
    private IRouteService routeService;

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody RouteDTO dto) {
        Route route = routeService.createRoute(dto);
        return new ResponseEntity<>(route, HttpStatus.CREATED);
    }

    @PutMapping("/{routeId}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long routeId, @RequestBody RouteDTO dto) throws RouteNotFoundException {
        Route route = routeService.updateRoute(routeId, dto);
        return ResponseEntity.ok(route);
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long routeId) throws RouteNotFoundException {
        routeService.deleteRoute(routeId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long routeId) throws RouteNotFoundException {
        Route route = routeService.getRouteById(routeId);
        return ResponseEntity.ok(route);
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        return ResponseEntity.ok(routeService.getAllRoutes());
    }
}
