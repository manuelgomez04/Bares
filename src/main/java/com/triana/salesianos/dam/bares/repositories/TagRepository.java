package com.triana.salesianos.dam.bares.repositories;

import com.triana.salesianos.dam.bares.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tags, Long> {
}
