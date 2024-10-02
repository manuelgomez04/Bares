package com.triana.salesianos.dam.bares.services;

import com.triana.salesianos.dam.bares.models.Bar;
import com.triana.salesianos.dam.bares.repositories.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarService {

    @Autowired
    private BarRepository barRepository;

    public List<Bar> findAll() {
        return barRepository.findAll();
    }

    public Bar findById(Long id) {
        return barRepository.findById(id).orElse(null);
    }

    public Bar editBar (Bar b) {

        return barRepository.save(b);
    }
}
