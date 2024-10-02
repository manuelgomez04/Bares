package com.triana.salesianos.dam.bares.repositories;

import com.triana.salesianos.dam.bares.models.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Long> {
}
