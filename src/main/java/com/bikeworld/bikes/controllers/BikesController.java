package com.bikeworld.bikes.controllers;

import com.bikeworld.bikes.models.Bike;
import com.bikeworld.bikes.repositories.BikeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    private final BikeRepository bikeRepository;

    public BikesController(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @GetMapping
    public List<Bike> list() {
        return bikeRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Bike bike) {
        bikeRepository.save(bike);
    }

    @GetMapping("/{id}")
    public Optional<Bike> get(@PathVariable("id") long id) {
        return bikeRepository.findById(id);
    }

}
